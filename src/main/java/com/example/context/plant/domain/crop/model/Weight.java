package com.example.context.plant.domain.crop.model;

import com.example.shared.ValueObject;
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
