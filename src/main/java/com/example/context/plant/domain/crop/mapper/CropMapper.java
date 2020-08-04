package com.example.context.plant.domain.crop.mapper;

import com.example.context.plant.domain.crop.command.CreateCropCommand;
import com.example.context.plant.domain.crop.model.Crop;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CropMapper {
  CropMapper INSTANCE = Mappers.getMapper(CropMapper.class);

//  @Mapping(target = "id",
//		  defaultExpression = "java(java.util.UUID.randomUUID().toString())")
  Crop createCropCommandToCrop(CreateCropCommand createCropCommand);
}
