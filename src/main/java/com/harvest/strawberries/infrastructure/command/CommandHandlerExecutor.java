
package com.harvest.strawberries.infrastructure.command;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class CommandHandlerExecutor {
	
	private final HandlerProvider handlerProvider;
	
	public void handle(Object command) {
		CommandHandler<Object> handler = handlerProvider.getHandler(command);
		handler.handle(command);
	}

}
