package com.cellarcollective.packing;

import com.cellarcollective.packing.domain.Bottle;

import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    // list of items to put in the bag to have the maximal value
    private List<Bottle> bottles;
    // maximal value possible
    private int value;

    public Solution(List<Bottle> bottles, int value) {
        this.bottles = bottles;
        this.value = value;
    }

    public void display() {
        if (bottles != null && !bottles.isEmpty()) {
            System.out.println("\nKnapsack solution");
            System.out.println("Value = " + value/1000+" KG");
            System.out.println("Items to pick :");

            for (Bottle bottle : bottles) {
                System.out.println("- " + bottle.str());
            }
        }
    }

    public List<Bottle> diff(List<Bottle> source) {
        List<Bottle> diff = source.stream()
                .filter(bottle -> bottles.stream().noneMatch(solutionBottle -> solutionBottle.getName().equals(bottle.getName())))
                .collect(Collectors.toList());

        System.out.println("Items left unpacked:");
        for (Bottle bottle : diff) {
            System.out.println("- " + bottle.str());
        }
        return diff;
    }
}