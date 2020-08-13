package com.thoughtworks.ddd.domain.crop.repository;

import com.thoughtworks.ddd.domain.crop.model.read.CropDto;

import java.util.List;

public interface CropReadRepository {
    List<CropDto> findAll();
}
