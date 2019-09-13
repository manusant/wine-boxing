package com.cellarcollective.packing.domain;

public enum BoxType {

    EXTRA_SMALL(2, 3.95),
    SMALL(5, 4.25),
    MEDIUM(10, 4.85),
    LARGE(20, 5.15),
    EXTRA_LARGE(30, 6.3);

    private int capacity;
    private double price;

    BoxType(int capacity, double price) {
        this.capacity = capacity;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getCapacity() {
        return capacity;
    }
}
