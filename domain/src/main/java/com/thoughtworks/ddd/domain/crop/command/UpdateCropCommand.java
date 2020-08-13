package com.thoughtworks.ddd.domain.crop.command;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UpdateCropCommand {
    private String id;
    private String name;
    private String weight;
}
