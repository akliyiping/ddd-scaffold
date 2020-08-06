package com.example.context.plant.infrastructure.repository.db;

import com.example.context.plant.domain.crop.model.Crop;
import com.example.context.plant.domain.crop.model.Weight;
import com.example.context.plant.userInterface.crop.dto.CropDto;
import com.example.shared.Entity;

public class CropConverter {
    public static CropDto cropEntityToCropDto(CropEntity cropEntity) {
        return CropDto.builder().id(cropEntity.getId()).name(cropEntity.getName()).weight(cropEntity.getWeight()).build();
    }

    public static CropEntity cropToCropEntity(Crop crop) {
        CropEntity cropEntity = new CropEntity();
        cropEntity.setId(crop.getId());
        cropEntity.setName(crop.getName());
        cropEntity.setWeight(crop.getWeight().getValue());
        return cropEntity;
    }

    public static Crop cropEntityToCrop(CropEntity cropEntity) {
        return Crop.builder()
                .id(cropEntity.getId())
                .name(cropEntity.getName())
                .weight(Weight.builder().value(cropEntity.getWeight()).build())
                .build();
    }
}
