package com.thoughtworks.ddd.repository.memory;

import com.thoughtworks.ddd.domain.crop.model.read.CropDto;
import com.thoughtworks.ddd.domain.crop.repository.CropReadRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MemoryCropReadRepository implements CropReadRepository {
    @Override
    public List<CropDto> findAll() {
        return MemoryCropRepository.CROP_LIST.stream()
                .map(crop -> CropDto.builder().name(crop.getName()).build())
                .collect(Collectors.toList());
    }

    @Override
    public CropDto findById(String id) {
        return MemoryCropRepository.CROP_LIST.stream()
                .filter(crop -> id.equals(crop.getId()))
                .map(crop -> CropDto.builder().name(crop.getName()).build())
                .findFirst()
                .orElseGet(null);
    }
}
