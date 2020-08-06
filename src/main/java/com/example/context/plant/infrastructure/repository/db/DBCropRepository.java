package com.example.context.plant.infrastructure.repository.db;

import com.example.context.plant.domain.crop.model.Crop;
import com.example.context.plant.domain.crop.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DBCropRepository implements CropRepository {
  @Autowired
  private DBCropJpaClient dbCropJpaClient;

  @Override
  public Crop find(String id) {
    CropEntity cropEntity = dbCropJpaClient.findById(id).orElseThrow(RuntimeException::new);
    return CropConverter.cropEntityToCrop(cropEntity);
  }

  @Override
  public Crop save(Crop crop) {
    dbCropJpaClient.save(CropConverter.cropToCropEntity(crop));
    return crop;
  }

  @Override
  public Crop update(Crop crop) {
    dbCropJpaClient.save(CropConverter.cropToCropEntity(crop));
    return crop;
  }

}
