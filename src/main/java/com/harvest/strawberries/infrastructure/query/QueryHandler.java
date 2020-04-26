package com.harvest.strawberries.infrastructure.query;

public interface QueryHandler<C,R> {

    R handle(C query);
}
