package com.cellarcollective.packing.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Box {

    private BoxType type;
    private double price;
    private int capacity;
    private List<Bottle> bottles;

    public Box(BoxType type) {
        this.type = type;
        this.price = type.getPrice();
        this.capacity = type.getCapacity();
        this.bottles = new ArrayList<>();
    }

    public void addBottles(List<Bottle> bottles) {
        this.bottles.addAll(bottles);
    }

    public void addBottle(Bottle bottle) {
        this.bottles.add(bottle);
    }

    @Override
    public String toString() {
        return type + " BOX (" + capacity + " KG)";
    }
}
