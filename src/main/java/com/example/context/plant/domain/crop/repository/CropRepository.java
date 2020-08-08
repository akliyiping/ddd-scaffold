package com.example.context.plant.domain.crop.repository;

import com.example.context.plant.domain.crop.model.Crop;

public interface CropRepository {
    Crop find(String id);

    Crop save(Crop crop);

    Crop update(Crop crop);
}
