package com.example.context.plant.domain.crop.event;

import com.example.context.plant.domain.crop.model.Crop;
import lombok.Builder;
import lombok.Setter;

import java.time.Instant;

@Setter
@Builder
public class CropUpdatedEvent {
  private Instant createdDate;
  private Crop crop;

  public static CropUpdatedEvent create(Crop crop) {
    return CropUpdatedEvent.builder()
            .crop(crop)
            .createdDate(Instant.now())
            .build();
  }
}
