package com.zoo;

import com.zoo.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void createMonkey() {
        Monkey m = new Monkey("Чита", 5, true, 7);
        assertEquals("Чита", m.getName());
        assertEquals(5, m.getFood());
        assertEquals(7, m.getKindness());
    }

    @Test
    void createRabbit() {
        Rabbit r = new Rabbit("Пушок", 2, true, 9);
        assertEquals("Пушок", r.getName());
        assertEquals(2, r.getFood());
    }

    @Test
    void createTiger() {
        Tiger t = new Tiger("Шерхан", 15, true);
        assertEquals("Шерхан", t.getName());
        assertEquals(15, t.getFood());
    }

    @Test
    void createWolf() {
        Wolf w = new Wolf("Акела", 10, true);
        assertEquals("Акела", w.getName());
        assertEquals(10, w.getFood());
    }

    @Test
    void contactFriendlyTrue() {
        Rabbit r = new Rabbit("Добрый", 2, true, 8);
        assertTrue(r.isContactFriendly());
    }

    @Test
    void contactFriendlyFalse() {
        Rabbit r = new Rabbit("Злой", 2, true, 3);
        assertFalse(r.isContactFriendly());
    }

    @Test
    void contactFriendlyBorder() {
        Rabbit r = new Rabbit("Средний", 2, true, 5);
        assertFalse(r.isContactFriendly()); // >5, не >=5
    }

    @Test
    void inventoryNumber() {
        Tiger t = new Tiger("Тест", 10, true);
        t.setNumber(42);
        assertEquals(42, t.getNumber());
    }
}
