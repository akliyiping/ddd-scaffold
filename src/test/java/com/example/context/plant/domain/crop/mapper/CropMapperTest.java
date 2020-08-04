package com.example.context.plant.domain.crop.mapper;

import com.example.context.plant.domain.crop.command.CreateCropCommand;
import com.example.context.plant.domain.crop.model.Crop;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
class CropMapperTest {
  @Test
  void createCropCommandToCrop() {
    CreateCropCommand cropCommand = CreateCropCommand
            .builder()
            .name("土豆")
            .build();
    Crop potato = CropMapper.INSTANCE.createCropCommandToCrop(cropCommand
    );
    assertEquals(potato.getName(), cropCommand.getName());
  }
}
