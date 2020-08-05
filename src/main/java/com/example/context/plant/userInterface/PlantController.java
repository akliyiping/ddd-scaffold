package com.example.context.plant.userInterface;

import com.example.context.plant.application.PlantApplicationService;
import com.example.context.plant.domain.crop.command.CreationCropCommand;
import com.example.context.plant.domain.crop.event.CropCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plant")
public class PlantController {
    @Autowired
    private PlantApplicationService plantApplicationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CropCreatedEvent create(@RequestBody final CreationCropCommand creationCropCommand) {
        return plantApplicationService.createCrop(creationCropCommand);
    }
}
