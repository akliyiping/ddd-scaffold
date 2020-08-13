package com.thoughtworks.ddd.listeners;

import com.thoughtworks.ddd.domain.crop.event.CropCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CropCreatedEventListener implements ApplicationListener<CropCreatedEvent> {
    @Override
    public void onApplicationEvent(CropCreatedEvent cropCreatedEvent) {
        log.info(cropCreatedEvent.toString());
    }
}
