package com.cellarcollective.packing.domain;

import lombok.Getter;

@Getter
public class Bottle {

    private BottleType type;
    private String name;
    private int value;
    private int weight;

    public Bottle(String name, BottleType type) {
        this.name = name;
        this.type = type;
        this.value = type.getWeight();
        this.weight = type.getWeight();
    }

    public String str() {
        return name + " [type = " + type + ", weight = " + weight + " Gr]";
    }
}