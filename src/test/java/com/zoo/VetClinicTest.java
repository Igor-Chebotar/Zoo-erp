package com.zoo;

import com.zoo.model.*;
import com.zoo.service.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VetClinicTest {

    private VetClinic clinic = new VetClinicImpl();

    @Test
    void healthyPasses() {
        Tiger t = new Tiger("Здоровый", 15, true);
        assertTrue(clinic.checkHealth(t));
    }

    @Test
    void sickFails() {
        Tiger t = new Tiger("Больной", 15, false);
        assertFalse(clinic.checkHealth(t));
    }
}
