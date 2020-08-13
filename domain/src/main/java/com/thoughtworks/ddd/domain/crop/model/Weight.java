package com.thoughtworks.ddd.domain.crop.model;

import com.thoughtworks.ddd.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@ValueObject
@Getter
@Builder
@AllArgsConstructor
public class Weight {
    private String value;
}
