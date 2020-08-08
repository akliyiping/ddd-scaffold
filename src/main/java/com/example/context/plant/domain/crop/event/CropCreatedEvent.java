package com.example.context.plant.domain.crop.event;

import com.example.context.plant.domain.crop.model.Crop;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

import java.time.Instant;

@Getter
@Setter
@ToString
public class CropCreatedEvent extends ApplicationEvent {
    private Instant createdDate;
    private Crop crop;

    public CropCreatedEvent(Object source, Instant createdDate, Crop crop) {
        super(source);
        this.createdDate = createdDate;
        this.crop = crop;
    }

    public static CropCreatedEvent create(Crop crop) {
        return new CropCreatedEvent(crop, Instant.now(), crop);
    }
}
