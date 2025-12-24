package com.zoo;

import com.zoo.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ThingTest {

    @Test
    void createTable() {
        Table t = new Table("Офисный");
        assertEquals("Офисный", t.getName());
    }

    @Test
    void createComputer() {
        Computer c = new Computer("Dell");
        assertEquals("Dell", c.getName());
    }

    @Test
    void inventoryNumber() {
        Table t = new Table("Тест");
        t.setNumber(100);
        assertEquals(100, t.getNumber());
    }
}
