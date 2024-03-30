package com.learn.graphql.resolver;

import com.learn.graphql.model.Asset;
import com.learn.graphql.model.BankAccount;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class AssetResolver implements GraphQLResolver<BankAccount> {
    public CompletableFuture<DataFetcherResult<List<Asset>>> assets(BankAccount bankAccount) {
        return CompletableFuture.supplyAsync(() -> {
                    log.info("Requesting asset data for bank account id: {}", bankAccount.getId());
                    return DataFetcherResult.<List<Asset>>newResult()
                            .data(Collections.singletonList(Asset.builder()
                                    .id(UUID.randomUUID())
                                    .build()))
                            .error(new GenericGraphQLError("AssetResolver went wrong"))
                            .build();
                },
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
        );
    }
}
