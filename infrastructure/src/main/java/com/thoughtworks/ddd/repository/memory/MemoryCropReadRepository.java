package com.thoughtworks.ddd.repository.memory;

import com.thoughtworks.ddd.domain.crop.read.dto.CropInfoDto;
import com.thoughtworks.ddd.domain.crop.repository.CropReadRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MemoryCropReadRepository implements CropReadRepository {
    @Override
    public List<CropInfoDto> findAll() {
        return MemoryCropRepository.CROP_LIST.stream()
                .map(crop -> CropInfoDto.builder().name(crop.getName()).build())
                .collect(Collectors.toList());
    }

    @Override
    public CropInfoDto findById(String id) {
        return MemoryCropRepository.CROP_LIST.stream()
                .filter(crop -> id.equals(crop.getId()))
                .map(crop -> CropInfoDto.builder().name(crop.getName()).build())
                .findFirst()
                .orElseGet(null);
    }
}
