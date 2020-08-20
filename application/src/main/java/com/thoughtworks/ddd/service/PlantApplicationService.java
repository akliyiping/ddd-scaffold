package com.thoughtworks.ddd.service;

import com.thoughtworks.ddd.domain.crop.command.CropCreationCommand;
import com.thoughtworks.ddd.domain.crop.command.CropUpdateCommand;
import com.thoughtworks.ddd.domain.crop.event.CropCreatedEvent;
import com.thoughtworks.ddd.domain.crop.event.CropUpdatedEvent;
import com.thoughtworks.ddd.domain.crop.model.Crop;
import com.thoughtworks.ddd.domain.crop.repository.CropRepository;
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

    public CropCreatedEvent createCrop(CropCreationCommand cropCreationCommand) {
        Crop crop = Crop.create(cropCreationCommand);
        crop = cropRepository.save(crop);
        CropCreatedEvent cropCreatedEvent = CropCreatedEvent.create(crop);
        eventPublisher.publishEvent(cropCreatedEvent);
        return cropCreatedEvent;
    }

    public CropUpdatedEvent updateCrop(CropUpdateCommand cropUpdateCommand) {
        Crop crop = cropRepository.find(cropUpdateCommand.getId());
        crop.merge(cropUpdateCommand);
        cropRepository.update(crop);
        CropUpdatedEvent cropUpdatedEvent = CropUpdatedEvent.create(crop);
        eventPublisher.publishEvent(cropUpdatedEvent);
        return cropUpdatedEvent;
    }
}
