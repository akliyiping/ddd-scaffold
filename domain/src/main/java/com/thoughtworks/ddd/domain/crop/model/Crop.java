package com.thoughtworks.ddd.domain.crop.model;

import com.thoughtworks.ddd.domain.crop.command.CropCreationCommand;
import com.thoughtworks.ddd.domain.crop.command.CropUpdateCommand;
import com.thoughtworks.ddd.shared.AggregateRoot;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@AggregateRoot
@Builder
@Data
public class Crop {
    private String id;
    private String name;
    private Weight weight;

    public static Crop create(CropCreationCommand cropCreationCommand) {
        return Crop.builder()
                .id(UUID.randomUUID().toString())
                .name(cropCreationCommand.getName())
                .weight(Weight.builder().value(cropCreationCommand.getWeight()).build())
                .build();
    }

    public void merge(CropUpdateCommand cropUpdateCommand) {
        this.setName(cropUpdateCommand.getName());
        this.setWeight(
                Weight.builder().value(cropUpdateCommand.getWeight()).build()
        );
    }
}
