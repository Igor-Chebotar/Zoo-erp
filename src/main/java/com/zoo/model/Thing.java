package com.zoo.model;

public abstract class Thing implements IInventory {
    private String name;
    private int number;

    public Thing(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }
}
