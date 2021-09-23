package com.speedhome.poc.service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class EmployeeIdGenerator {
    @Value("1")
    private String indexerModifier;

    public long generateRequestId() {
        return Long.valueOf(Long.toString(Instant.now().getEpochSecond()) + indexerModifier);
    }
}
