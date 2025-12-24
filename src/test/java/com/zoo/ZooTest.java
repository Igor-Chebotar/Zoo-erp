package com.zoo;

import com.zoo.model.*;
import com.zoo.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ZooTest {

    private Zoo zoo;

    @BeforeEach
    void setUp() {
        zoo = new Zoo(new VetClinicImpl());
    }

    @Test
    void addHealthyAnimal() {
        Tiger t = new Tiger("Шерхан", 15, true);
        assertTrue(zoo.addAnimal(t));
        assertEquals(1, zoo.getAnimals().size());
    }

    @Test
    void rejectSickAnimal() {
        Tiger t = new Tiger("Больной", 15, false);
        assertFalse(zoo.addAnimal(t));
        assertEquals(0, zoo.getAnimals().size());
    }

    @Test
    void assignsNumber() {
        Tiger t = new Tiger("Тигр", 15, true);
        zoo.addAnimal(t);
        assertEquals(1, t.getNumber());
    }

    @Test
    void totalFood() {
        zoo.addAnimal(new Tiger("Тигр", 15, true));
        zoo.addAnimal(new Wolf("Волк", 10, true));
        assertEquals(25, zoo.getTotalFood());
    }

    @Test
    void totalFoodEmpty() {
        assertEquals(0, zoo.getTotalFood());
    }

    @Test
    void contactAnimals() {
        zoo.addAnimal(new Rabbit("Добрый", 2, true, 8));
        zoo.addAnimal(new Rabbit("Злой", 2, true, 3));
        zoo.addAnimal(new Tiger("Тигр", 15, true));

        var contact = zoo.getContactAnimals();
        assertEquals(1, contact.size());
        assertEquals("Добрый", contact.get(0).getName());
    }

    @Test
    void addThing() {
        Table t = new Table("Стол");
        zoo.addThing(t);
        assertEquals(1, zoo.getThings().size());
        assertEquals(100, t.getNumber());
    }
}
