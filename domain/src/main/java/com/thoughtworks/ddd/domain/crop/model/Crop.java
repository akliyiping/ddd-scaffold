package com.thoughtworks.ddd.domain.crop.model;

import com.thoughtworks.ddd.domain.crop.command.CreationCropCommand;
import com.thoughtworks.ddd.domain.crop.command.UpdateCropCommand;
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

    public static Crop create(CreationCropCommand creationCropCommand) {
        return Crop.builder()
                .id(UUID.randomUUID().toString())
                .name(creationCropCommand.getName())
                .weight(Weight.builder().value(creationCropCommand.getWeight()).build())
                .build();
    }

    public void merge(UpdateCropCommand updateCropCommand) {
        this.setName(updateCropCommand.getName());
        this.setWeight(
                Weight.builder().value(updateCropCommand.getWeight()).build()
        );
    }
}
