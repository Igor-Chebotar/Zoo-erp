package com.zoo.service;

import com.zoo.model.Animal;
import org.springframework.stereotype.Component;

@Component
public class VetClinicImpl implements VetClinic {
    @Override
    public boolean checkHealth(Animal animal) {
        return animal.isHealthy();
    }
}
