package com.zoo.model;

public abstract class Herbo extends Animal {
    private int kindness;

    public Herbo(String name, int food, boolean healthy, int kindness) {
        super(name, food, healthy);
        this.kindness = kindness;
    }

    public int getKindness() { return kindness; }

    public boolean isContactFriendly() {
        return kindness > 5;
    }
}
