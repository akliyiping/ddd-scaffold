package com.thoughtworks.ddd.repository.db;

import com.thoughtworks.ddd.domain.crop.model.read.CropDto;
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
    public List<CropDto> findAll() {
        return dBCropJpaClient.findAll().stream().map(CropConverter::cropEntityToCropDto).collect(Collectors.toList());
    }
}
