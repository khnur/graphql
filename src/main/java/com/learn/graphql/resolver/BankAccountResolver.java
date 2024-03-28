package com.learn.graphql.resolver;

import com.learn.graphql.model.BankAccount;
import com.learn.graphql.model.Client;
import com.learn.graphql.model.Currency;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {
    public BankAccount bankAccount(UUID id) {
        log.info("Retrieving bank account id: {}", id);
        return BankAccount.builder()
                .id(id)
                .currency(Currency.KZT)
                .client(Client.builder()
                        .name("Philips")
                        .middleNames(List.of("ion", "nion"))
                        .surname("Non-null")
                        .build())
                .build();
    }
}
