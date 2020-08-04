package com.example.context.plant.domain.crop.event;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class CropCreatedEvent {
  private String name;
  private Instant createdDate;
}
