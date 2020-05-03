package com.harvest.strawberries.infrastructure.query;

public interface QueryProvider<T, R> {

    QueryHandler<T, R> getQueryHandler(Object query);
}