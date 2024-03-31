package com.learn.graphql.model.input;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBankAccountInput {
    String name;
}
