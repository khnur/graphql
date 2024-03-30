package com.learn.graphql.model;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class Asset {
    UUID id;
}
