package com.thoughtworks.ddd.domain.crop.read.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CropInfoDto {
    private String id;
    private String name;
    private String weight;
}
