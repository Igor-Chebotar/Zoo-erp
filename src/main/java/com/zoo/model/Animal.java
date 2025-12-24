package com.zoo.model;

public abstract class Animal implements IAlive, IInventory {
    private String name;
    private int food;
    private int number;
    private boolean healthy;

    public Animal(String name, int food, boolean healthy) {
        this.name = name;
        this.food = food;
        this.healthy = healthy;
    }

    public String getName() { return name; }
    public int getFood() { return food; }
    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }
    public boolean isHealthy() { return healthy; }
}
