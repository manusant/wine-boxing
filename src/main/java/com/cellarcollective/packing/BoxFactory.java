package com.cellarcollective.packing;

import com.cellarcollective.packing.domain.Box;
import com.cellarcollective.packing.domain.BoxType;

public class BoxFactory {

    public static Box pick(int weight) {
        if (weight > 20_000) {
            return new Box(BoxType.EXTRA_LARGE);
        } else if (weight > 10_000) {
            return new Box(BoxType.LARGE);
        } else if (weight > 5_000) {
            return new Box(BoxType.MEDIUM);
        } else if (weight > 2_000) {
            return new Box(BoxType.SMALL);
        } else {
            return new Box(BoxType.EXTRA_SMALL);
        }
    }
}
