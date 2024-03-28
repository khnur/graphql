package com.learn.graphql.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@Builder
public class Client {
    UUID id;
    String name;
    String surname;
    List<String> middleNames;
}
