package com.example.context.plant.domain.crop.command;

import com.example.context.plant.domain.crop.model.Weight;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class CreationCropCommand {
  private String name;
  private String weight;
}
