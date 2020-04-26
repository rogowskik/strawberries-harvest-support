package com.harvest.strawberries.infrastructure.command;

public interface CommandHandler<C> {

   void handle(C command);
}