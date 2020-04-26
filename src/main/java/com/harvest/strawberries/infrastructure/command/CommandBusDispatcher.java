package com.harvest.strawberries.infrastructure.command;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommandBusDispatcher {

	private final CommandHandlerExecutor commandHandlerExecutor;

	public void dispatch(Object command) {
		commandHandlerExecutor.handle(command);
	}
}
