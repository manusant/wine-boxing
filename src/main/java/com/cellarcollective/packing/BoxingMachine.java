package com.cellarcollective.packing;

import com.cellarcollective.packing.domain.Bottle;
import com.cellarcollective.packing.domain.BottleType;
import com.cellarcollective.packing.domain.Box;

import java.util.Arrays;
import java.util.List;

public class BoxingMachine {

    public static void main(String[] args) {
        // we take the same instance of the problem displayed in the image
        List<Bottle> bottles = Arrays.asList(
                new Bottle("W0", BottleType.STANDARD),
                new Bottle("W0", BottleType.STANDARD),
                new Bottle("W0", BottleType.STANDARD),
                new Bottle("W1", BottleType.MAGNUM),
                new Bottle("W2", BottleType.MAGNUM),
                new Bottle("W3", BottleType.MAGNUM),
                new Bottle("W4", BottleType.SPLIT),
                new Bottle("W5", BottleType.PICCOLO),
                new Bottle("W6", BottleType.PICCOLO),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W7", BottleType.MAGNUM),
                new Bottle("W8", BottleType.SPLIT)
        );

        while (!bottles.isEmpty()) {
            System.out.println("=====================================");
            Box box = BoxFactory.pick(calculateWeight(bottles));
            Knapsack knapsack = new Knapsack(bottles.toArray(new Bottle[]{}), box.getCapacity() * 1000);
            knapsack.display();

            System.out.println("Selected BOX: " + box.toString());
            Solution solution = knapsack.solve();
            solution.display();
            bottles = solution.diff(bottles);
        }
    }

    private static int calculateWeight(List<Bottle> bottles) {
        return bottles.stream()
                .mapToInt(Bottle::getWeight)
                .sum();
    }
}
