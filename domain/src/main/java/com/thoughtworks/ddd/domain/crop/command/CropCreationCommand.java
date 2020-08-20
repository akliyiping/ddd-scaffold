package com.thoughtworks.ddd.domain.crop.command;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class CropCreationCommand {
    private String name;
    private String weight;
}
