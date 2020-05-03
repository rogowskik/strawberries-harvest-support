package com.harvest.strawberries.infrastructure.registry;

import com.harvest.strawberries.infrastructure.command.CommandHandler;
import com.harvest.strawberries.infrastructure.command.HandlerProvider;
import com.harvest.strawberries.infrastructure.query.QueryHandler;
import com.harvest.strawberries.infrastructure.query.QueryProvider;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class CqrsRegistry implements HandlerProvider, QueryProvider, ApplicationListener<ContextRefreshedEvent> {

    public CqrsRegistry(ConfigurableListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
    private final ConfigurableListableBeanFactory beanFactory;

    private Map<Class<?>, String> handlers = new HashMap<>();
    private Map<Class<?>, String> queryHandlers = new HashMap<>();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        handlers.clear();
        String[] commandHandlersNames = beanFactory.getBeanNamesForType(CommandHandler.class);
        Arrays.stream(commandHandlersNames).forEach(beanName -> {
            BeanDefinition commandHandler = beanFactory.getBeanDefinition(beanName);
            try {
                Class<?> handlerClass = Class.forName(commandHandler.getBeanClassName());
                handlers.put(getHandledCommandType(handlerClass, CommandHandler.class), beanName);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        String[] queryHandlerNames = beanFactory.getBeanNamesForType(QueryHandler.class);
        Arrays.stream(queryHandlerNames).forEach(beanName -> {
            BeanDefinition queryHandler = beanFactory.getBeanDefinition(beanName);
            try {
                Class<?> handlerClass = Class.forName(queryHandler.getBeanClassName());
                queryHandlers.put(getHandledCommandType(handlerClass, QueryHandler.class), beanName);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

    }

	@Override
    public CommandHandler<Object> getHandler(Object command) {
        String beanName = handlers.get(command.getClass());
        if (beanName == null) {
            throw new RuntimeException("command handler not found for: " + command.getClass());
        }
        CommandHandler<Object> handler = beanFactory.getBean(beanName, CommandHandler.class);
        return handler;
    }



    private Class<?> getHandledCommandType(Class<?> clazz,  Class<?> expected ) {
        Type[] genericInterfaces = clazz.getGenericInterfaces();
        ParameterizedType type = findByRawType(genericInterfaces, expected);
        return (Class<?>) type.getActualTypeArguments()[0];
    }

    private ParameterizedType findByRawType(Type[] genericInterfaces, Class<?> expectedRawType) {
        for (Type type : genericInterfaces) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parametrized = (ParameterizedType) type;
                if (expectedRawType.equals(parametrized.getRawType())) {
                    return parametrized;
                }
            }
        }
        throw new RuntimeException();
    }

    @Override
    public QueryHandler getQueryHandler(Object query) {
        String beanName = queryHandlers.get(query.getClass());
        if (beanName == null) {
            throw new RuntimeException("command handler not found for: " + query.getClass());
        }
        return beanFactory.getBean(beanName, QueryHandler.class);
    }
}
