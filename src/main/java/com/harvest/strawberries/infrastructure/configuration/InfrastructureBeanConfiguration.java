package com.harvest.strawberries.infrastructure.configuration;

import com.harvest.strawberries.infrastructure.command.CommandBusDispatcher;
import com.harvest.strawberries.infrastructure.command.CommandHandlerExecutor;
import com.harvest.strawberries.infrastructure.query.QueryBusDispatcher;
import com.harvest.strawberries.infrastructure.query.QueryHandlerExecutor;
import com.harvest.strawberries.infrastructure.registry.CqrsRegistry;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfrastructureBeanConfiguration {

    @Bean
    CqrsRegistry commandHandlersRegistry(ConfigurableListableBeanFactory configurableListableBeanFactory) {
        return new CqrsRegistry(configurableListableBeanFactory);
    }

    @Bean
    CommandHandlerExecutor commandHandlerExecutor(CqrsRegistry cqrsRegistry) {
        return new CommandHandlerExecutor(cqrsRegistry);
    }

    @Bean
    CommandBusDispatcher commandBusDispatcher(CommandHandlerExecutor commandHandlerExecutor) {
        return new CommandBusDispatcher(commandHandlerExecutor);
    }


    @Bean
    QueryHandlerExecutor queryHandlerExecutor(CqrsRegistry cqrsRegistry) {
        return new QueryHandlerExecutor(cqrsRegistry);
    }

    @Bean
    QueryBusDispatcher QueryBusDispatcher(QueryHandlerExecutor queryHandlerExecutor) {
        return new QueryBusDispatcher(queryHandlerExecutor);
    }

}
