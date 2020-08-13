package com.thoughtworks.ddd.domain.crop.model.read;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CropDto {
    private String id;
    private String name;
    private String weight;
}
