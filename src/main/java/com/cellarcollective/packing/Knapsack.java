package com.cellarcollective.packing;


import com.cellarcollective.packing.domain.Bottle;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {

    // items of our problem
    private Bottle[] bottles;
    // capacity of the bag
    private int capacity;

    public Knapsack(Bottle[] bottles, int capacity) {
        this.bottles = bottles;
        this.capacity = capacity;
    }

    // we write the solve algorithm
    public Solution solve() {
        int numberOfItems = bottles.length;
        // we use a matrix to store the max value at each n-th item
        int[][] matrix = new int[numberOfItems + 1][capacity + 1];

        // first line is initialized to 0
        for (int i = 0; i <= capacity; i++) {
            matrix[0][i] = 0;
        }

        // we iterate on items
        for (int i = 1; i <= numberOfItems; i++) {
            // we iterate on each capacity
            for (int j = 0; j <= capacity; j++) {
                if (bottles[i - 1].getWeight() > j) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    // we maximize value at this rank in the matrix
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - bottles[i - 1].getWeight()]
                            + bottles[i - 1].getValue());
                }
            }
        }

        int res = matrix[numberOfItems][capacity];
        int w = capacity;
        List<Bottle> itemsSolution = new ArrayList<>();

        for (int i = numberOfItems; i > 0 && res > 0; i--) {
            if (res != matrix[i - 1][w]) {
                itemsSolution.add(bottles[i - 1]);
                // we remove items value and weight
                res -= bottles[i - 1].getValue();
                w -= bottles[i - 1].getWeight();
            }
        }

        return new Solution(itemsSolution, matrix[numberOfItems][capacity]);
    }

    public void display() {
        if (bottles != null && bottles.length > 0) {
            System.out.println("Knapsack problem");
            System.out.println("Items :");

            for (Bottle bottle : bottles) {
                System.out.println("- " + bottle.str());
            }
        }
    }
}