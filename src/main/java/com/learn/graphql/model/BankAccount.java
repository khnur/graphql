package com.learn.graphql.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@Builder
public class BankAccount {
    UUID id;
    Client client;
    Currency currency;
    List<Asset> assets;
}
