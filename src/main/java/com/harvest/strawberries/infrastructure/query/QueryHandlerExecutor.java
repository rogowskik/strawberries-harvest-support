package com.harvest.strawberries.infrastructure.query;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class QueryHandlerExecutor<C, R> {

    private final QueryProvider<C,R> queryProvider;

    public R handle(C query) {
        QueryHandler<C, R> queryHandler = queryProvider.getQueryHandler(query);
        return queryHandler.handle(query);
    }
}
