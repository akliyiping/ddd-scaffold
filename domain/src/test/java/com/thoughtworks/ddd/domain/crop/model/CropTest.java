package com.thoughtworks.ddd.domain.crop.model;

import com.thoughtworks.ddd.domain.crop.command.CreationCropCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CropTest {
    @Test
    void create() {
        CreationCropCommand creationCropCommand = CreationCropCommand.builder()
                .name("li")
                .weight("6kg")
                .build();
        Crop crop = Crop.create(creationCropCommand);
        assertEquals(creationCropCommand.getWeight(), crop.getWeight().getValue());
        assertEquals(creationCropCommand.getName(), crop.getName());
        assertNotNull(crop.getId());
    }
}
