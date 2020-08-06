package com.example.context.plant.infrastructure.repository.db;

import com.example.context.plant.userInterface.crop.dto.CropDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DBCropQueryRepository{
    @Autowired
    private DBCropJpaClient dBCropJpaClient;

    public List<CropDto> findAll() {
        return dBCropJpaClient.findAll().stream().map(CropConverter::cropEntityToCropDto).collect(Collectors.toList());
    }
}
