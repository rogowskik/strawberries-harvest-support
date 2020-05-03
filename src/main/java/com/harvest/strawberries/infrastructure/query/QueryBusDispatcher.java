package com.harvest.strawberries.infrastructure.query;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class QueryBusDispatcher<T, R> {

    private final QueryHandlerExecutor<T, R> queryHandlerExecutor;

    public R dispatch(T query) {
        return queryHandlerExecutor.handle(query);
    }
}
