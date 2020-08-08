package com.example.context.plant.application.service;

import com.example.context.plant.domain.crop.command.CreationCropCommand;
import com.example.context.plant.domain.crop.command.UpdateCropCommand;
import com.example.context.plant.domain.crop.event.CropCreatedEvent;
import com.example.context.plant.domain.crop.event.CropUpdatedEvent;
import com.example.context.plant.domain.crop.model.Crop;
import com.example.context.plant.domain.crop.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class PlantApplicationService {
    @Qualifier("DBCropRepository")
    @Autowired
    private CropRepository cropRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public CropCreatedEvent createCrop(CreationCropCommand creationCropCommand) {
        Crop crop = Crop.create(creationCropCommand);
        crop = cropRepository.save(crop);
        CropCreatedEvent cropCreatedEvent = CropCreatedEvent.create(crop);
        eventPublisher.publishEvent(cropCreatedEvent);
        return cropCreatedEvent;
    }

    public CropUpdatedEvent updateCrop(UpdateCropCommand updateCropCommand) {
        Crop crop = cropRepository.find(updateCropCommand.getId());
        crop.merge(updateCropCommand);
        cropRepository.update(crop);
        CropUpdatedEvent cropUpdatedEvent = CropUpdatedEvent.create(crop);
        eventPublisher.publishEvent(cropUpdatedEvent);
        return cropUpdatedEvent;
    }
}
