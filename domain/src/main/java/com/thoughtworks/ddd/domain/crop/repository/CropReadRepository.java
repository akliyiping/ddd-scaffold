package com.thoughtworks.ddd.domain.crop.repository;

import com.thoughtworks.ddd.domain.crop.read.dto.CropInfoDto;

import java.util.List;

public interface CropReadRepository {
    List<CropInfoDto> findAll();

    CropInfoDto findById(String id);
}
