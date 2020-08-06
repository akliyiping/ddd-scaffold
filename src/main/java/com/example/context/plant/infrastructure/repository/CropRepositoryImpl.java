package com.example.context.plant.infrastructure.repository;

import com.example.context.plant.domain.crop.model.Crop;
import com.example.context.plant.domain.crop.repository.CropRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CropRepositoryImpl implements CropRepository {
  final List<Crop> cropList = new ArrayList<>();

  @Override
  public Crop find(String id) {
	return cropList.stream().filter(crop -> crop.getId().equals(id)).findFirst().orElse(null);
  }

  @Override
  public Crop save(Crop crop) {
    cropList.add(crop);
    return crop;
  }

  @Override
  public Crop update(Crop crop) {
    Crop oldCrop = this.find(crop.getId());
    oldCrop.setWeight(crop.getWeight());
    oldCrop.setName(crop.getName());
    return oldCrop;
  }

}
