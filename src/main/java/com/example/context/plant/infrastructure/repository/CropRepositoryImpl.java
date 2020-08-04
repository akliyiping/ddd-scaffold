package com.example.context.plant.infrastructure.repository;

import com.example.context.plant.domain.crop.model.Crop;
import com.example.context.plant.domain.crop.repository.CropRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CropRepositoryImpl implements CropRepository {
  @Override
  public Crop find(String id) {
	return null;
  }

  @Override
  public void save(Crop blankQuiz) {

  }
}
