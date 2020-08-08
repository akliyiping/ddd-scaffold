package com.example.context.plant.application.listeners;

import com.example.context.plant.domain.crop.event.CropUpdatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CropUpdatedEventListener implements ApplicationListener<CropUpdatedEvent> {
    @Override
    public void onApplicationEvent(CropUpdatedEvent cropUpdatedEvent) {
        log.info(cropUpdatedEvent.toString());
    }
}
