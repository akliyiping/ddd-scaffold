package com.thoughtworks.ddd.domain.crop.model;

import com.thoughtworks.ddd.domain.crop.command.CropCreationCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CropTest {
    @Test
    void create() {
        CropCreationCommand cropCreationCommand = CropCreationCommand.builder()
                .name("li")
                .weight("6kg")
                .build();
        Crop crop = Crop.create(cropCreationCommand);
        assertEquals(cropCreationCommand.getWeight(), crop.getWeight().getValue());
        assertEquals(cropCreationCommand.getName(), crop.getName());
        assertNotNull(crop.getId());
    }
}
