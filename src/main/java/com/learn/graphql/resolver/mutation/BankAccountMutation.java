package com.learn.graphql.resolver.mutation;

import com.learn.graphql.model.BankAccount;
import com.learn.graphql.model.Client;
import com.learn.graphql.model.Currency;
import com.learn.graphql.model.input.CreateBankAccountInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class BankAccountMutation implements GraphQLMutationResolver {
    BankAccount createBankAccount(CreateBankAccountInput input) {
        log.info("Creating bank account for {}", input);
        return BankAccount.builder()
                .id(UUID.randomUUID())
                .currency(Currency.KZT)
                .client(Client.builder()
                        .id(UUID.randomUUID())
                        .name(Optional.ofNullable(input).map(CreateBankAccountInput::getName).orElse(""))
                        .build())
                .build();
    }
}
