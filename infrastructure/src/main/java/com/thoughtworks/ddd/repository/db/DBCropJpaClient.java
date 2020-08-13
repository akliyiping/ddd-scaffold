package com.thoughtworks.ddd.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBCropJpaClient extends JpaRepository<CropEntity, String> {

}
