package com.thoughtworks.ddd;

import com.thoughtworks.ddd.domain.crop.command.CropCreationCommand;
import com.thoughtworks.ddd.domain.crop.command.CropUpdateCommand;
import com.thoughtworks.ddd.domain.crop.event.CropCreatedEvent;
import com.thoughtworks.ddd.domain.crop.event.CropUpdatedEvent;
import com.thoughtworks.ddd.domain.crop.read.dto.CropInfoDto;
import com.thoughtworks.ddd.domain.crop.repository.CropReadRepository;
import com.thoughtworks.ddd.service.PlantApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {
    @Autowired
    private PlantApplicationService plantApplicationService;

    @Qualifier("DBCropReadRepository")
    @Autowired
    private CropReadRepository cropReadRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CropCreatedEvent create(@RequestBody CropCreationCommand cropCreationCommand) {
        return plantApplicationService.createCrop(cropCreationCommand);
    }

    @PutMapping
    public CropUpdatedEvent update(@RequestBody CropUpdateCommand cropUpdateCommand) {
        return plantApplicationService.updateCrop(cropUpdateCommand);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CropInfoDto> query() {
        return cropReadRepository.findAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CropInfoDto queryById(@PathVariable String id) {
        return cropReadRepository.findById(id);
    }
}
