package com.example.context.plant.domain.crop.repository;

import com.example.context.plant.domain.crop.model.read.CropDto;

import java.util.List;

public interface CropReadRepository {
    List<CropDto> findAll();
}
