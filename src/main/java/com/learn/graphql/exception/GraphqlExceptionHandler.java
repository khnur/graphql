package com.learn.graphql.exception;

import graphql.GraphqlErrorException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@Component
public class GraphqlExceptionHandler {
    @ExceptionHandler(GraphqlErrorException.class)
    public ThrowableGraphQLError handle(GraphqlErrorException e) {
        log.error(e.getMessage());
        return new ThrowableGraphQLError(e);
    }
}
