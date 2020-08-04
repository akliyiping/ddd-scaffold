package com.example.context.plant.application;

import com.example.context.plant.domain.crop.command.CreateCropCommand;
import com.example.context.plant.domain.crop.mapper.CropMapper;
import com.example.context.plant.domain.crop.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantApplicationService {
  @Autowired
  private CropRepository cropRepository;

  public void createCrop(final CreateCropCommand command) {
	cropRepository.save(CropMapper.INSTANCE.createCropCommandToCrop(command));
  }
}
