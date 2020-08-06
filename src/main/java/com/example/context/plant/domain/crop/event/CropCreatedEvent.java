package com.example.context.plant.domain.crop.event;

import com.example.context.plant.domain.crop.model.Crop;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.awt.event.ComponentEvent;
import java.time.Instant;

@Data
@Builder
public class CropCreatedEvent {
  private Instant createdDate;
  private Crop crop;

  public static CropCreatedEvent create(Crop crop) {
    return CropCreatedEvent.builder()
            .crop(crop)
            .createdDate(Instant.now())
            .build();
  }
}
