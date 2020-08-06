package com.example.context.plant.infrastructure.repository;

import com.example.context.plant.userInterface.crop.dto.CropDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MemoryCropQueryRepository {
    public List<CropDto> queryList() {
        return MemoryCropRepository.CROP_LIST.stream().map(crop -> CropDto.builder().name(crop.getName()).build()).collect(Collectors.toList());
    }
}
