package com.example.context.plant.infrastructure.repository.memory;

import com.example.context.plant.domain.crop.model.read.CropDto;
import com.example.context.plant.domain.crop.repository.CropReadRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MemoryCropReadRepository implements CropReadRepository {
    @Override
    public List<CropDto> findAll() {
        return MemoryCropRepository.CROP_LIST.stream().map(crop -> CropDto.builder().name(crop.getName()).build()).collect(Collectors.toList());
    }
}
