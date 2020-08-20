package com.thoughtworks.ddd.repository.db;

import com.thoughtworks.ddd.domain.crop.read.dto.CropInfoDto;
import com.thoughtworks.ddd.domain.crop.repository.CropReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DBCropReadRepository implements CropReadRepository {
    @Autowired
    private DBCropJpaClient dBCropJpaClient;

    @Override
    public List<CropInfoDto> findAll() {
        return dBCropJpaClient.findAll().stream().map(CropConverter::cropEntityToCropDto).collect(Collectors.toList());
    }

    @Override
    public CropInfoDto findById(String id) {
        return dBCropJpaClient.findById(id).map(CropConverter::cropEntityToCropDto).orElseGet(null);
    }
}
