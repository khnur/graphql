package com.learn.graphql.resolver;

import com.learn.graphql.model.BankAccount;
import com.learn.graphql.model.Client;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {
    public CompletableFuture<DataFetcherResult<Client>> client(BankAccount bankAccount) {
        return CompletableFuture.supplyAsync(() -> {
                    log.info("Requesting client data for bank account id: {}", bankAccount.getId());
                    return DataFetcherResult.<Client>newResult()
                            .data(Client.builder()
                                    .id(UUID.randomUUID())
                                    .name("Nurzhan")
                                    .middleNames(List.of("ion", "nion"))
                                    .surname("Non-null")
                                    .build())
                            .error(new GenericGraphQLError("ClientResolver went wrong"))
                            .build();
                },
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
        );
    }
}
