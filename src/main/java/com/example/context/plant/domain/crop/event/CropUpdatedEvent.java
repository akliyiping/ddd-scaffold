package com.example.context.plant.domain.crop.event;

import com.example.context.plant.domain.crop.model.Crop;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class CropUpdatedEvent {
  private Instant updateDate;
  private Crop crop;

  public static CropUpdatedEvent create(Crop crop) {
    return CropUpdatedEvent.builder()
            .crop(crop)
            .updateDate(Instant.now())
            .build();
  }
}
