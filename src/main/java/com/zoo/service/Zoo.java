package com.zoo.service;

import com.zoo.model.*;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class Zoo {
    private final List<Animal> animals = new ArrayList<>();
    private final List<Thing> things = new ArrayList<>();
    private final VetClinic vetClinic;
    private int animalCounter = 1;
    private int thingCounter = 100;

    public Zoo(VetClinic vetClinic) {
        this.vetClinic = vetClinic;
    }

    public boolean addAnimal(Animal animal) {
        if (!vetClinic.checkHealth(animal)) {
            return false;
        }
        animal.setNumber(animalCounter++);
        animals.add(animal);
        return true;
    }

    public void addThing(Thing thing) {
        thing.setNumber(thingCounter++);
        things.add(thing);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Thing> getThings() {
        return things;
    }

    public int getTotalFood() {
        int total = 0;
        for (Animal a : animals) {
            total += a.getFood();
        }
        return total;
    }

    public List<Herbo> getContactAnimals() {
        List<Herbo> result = new ArrayList<>();
        for (Animal a : animals) {
            if (a instanceof Herbo) {
                Herbo h = (Herbo) a;
                if (h.isContactFriendly()) {
                    result.add(h);
                }
            }
        }
        return result;
    }
}
