package com.example.context.plant.domain.crop.model;

import com.example.shared.AggregateRoot;
import lombok.*;

@AggregateRoot
@Builder
@Getter
@Setter
@NoArgsConstructor
public class Crop {
  private String id;
  private String name;
  private Weight weight;
}
