package com.thoughtworks.ddd.repository.db;

import com.thoughtworks.ddd.domain.crop.model.Crop;
import com.thoughtworks.ddd.domain.crop.model.Weight;
import com.thoughtworks.ddd.domain.crop.read.dto.CropInfoDto;

public class CropConverter {
    public static CropInfoDto cropEntityToCropDto(CropEntity cropEntity) {
        return CropInfoDto.builder().id(cropEntity.getId()).name(cropEntity.getName()).weight(cropEntity.getWeight()).build();
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
