package com.thoughtworks.ddd.listeners;

import com.thoughtworks.ddd.domain.crop.event.CropUpdatedEvent;
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
