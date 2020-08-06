package com.example.context.plant.userInterface.crop;

import com.example.context.plant.application.PlantApplicationService;
import com.example.context.plant.domain.crop.command.CreationCropCommand;
import com.example.context.plant.domain.crop.command.UpdateCropCommand;
import com.example.context.plant.domain.crop.event.CropCreatedEvent;
import com.example.context.plant.domain.crop.event.CropUpdatedEvent;
import com.example.context.plant.infrastructure.repository.MemoryCropQueryRepository;
import com.example.context.plant.userInterface.crop.dto.CropDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {
    @Autowired
    private PlantApplicationService plantApplicationService;

    @Autowired
    private MemoryCropQueryRepository memoryCropQueryRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CropCreatedEvent create(@RequestBody CreationCropCommand creationCropCommand) {
        return plantApplicationService.createCrop(creationCropCommand);
    }

    @PutMapping
    public CropUpdatedEvent update(@RequestBody UpdateCropCommand updateCropCommand) {
        return plantApplicationService.updateCrop(updateCropCommand);
    }

    @PostMapping
    @RequestMapping("/query")
    @ResponseStatus(HttpStatus.OK)
    public List<CropDto> query() {
        return memoryCropQueryRepository.queryList();
    }
}
