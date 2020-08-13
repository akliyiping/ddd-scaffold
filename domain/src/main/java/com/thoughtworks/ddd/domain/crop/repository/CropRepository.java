package com.thoughtworks.ddd.domain.crop.repository;

import com.thoughtworks.ddd.domain.crop.model.Crop;

public interface CropRepository {
    Crop find(String id);

    Crop save(Crop crop);

    Crop update(Crop crop);
}
