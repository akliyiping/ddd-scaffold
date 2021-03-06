package com.thoughtworks.ddd.domain.crop.event;

import com.thoughtworks.ddd.domain.crop.model.Crop;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

import java.time.Instant;

@Getter
@Setter
@ToString
public class CropUpdatedEvent extends ApplicationEvent {
    private Instant createdDate;
    private Crop crop;

    public CropUpdatedEvent(Object source, Instant createdDate, Crop crop) {
        super(source);
        this.createdDate = createdDate;
        this.crop = crop;
    }

    public static CropUpdatedEvent create(Crop crop) {
        return new CropUpdatedEvent(crop, Instant.now(), crop);
    }
}
