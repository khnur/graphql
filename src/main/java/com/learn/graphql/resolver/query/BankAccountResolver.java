package com.learn.graphql.resolver.query;

import com.learn.graphql.model.BankAccount;
import com.learn.graphql.model.Currency;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {
    public DataFetcherResult<BankAccount> bankAccount(UUID id) {
        log.info("Retrieving bank account id: {}", id);
        return DataFetcherResult.<BankAccount>newResult()
                .data(BankAccount.builder()
                        .id(id)
                        .currency(Currency.KZT)
                        .build())
                .error(new GenericGraphQLError("BankAccountResolver went wrong"))
                .build();
    }
}
