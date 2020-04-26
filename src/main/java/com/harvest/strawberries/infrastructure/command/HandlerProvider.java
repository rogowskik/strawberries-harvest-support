package com.harvest.strawberries.infrastructure.command;

import com.harvest.strawberries.infrastructure.command.CommandHandler;

public interface HandlerProvider {

    CommandHandler<Object> getHandler(Object command);
}