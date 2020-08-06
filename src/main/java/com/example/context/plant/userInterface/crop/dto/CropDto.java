package com.example.context.plant.userInterface.crop.dto;

import com.example.context.plant.domain.crop.model.Weight;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CropDto {
    private String id;
    private String name;
    private String weight;
}
