package com.cellarcollective.packing.domain;

public enum BottleType {
    // TYPE (Wieght in gr)
    TOPETTE(100),
    PICCOLO(200),
    SPLIT(400),
    STANDARD(720),
    MAGNUM(1418),
    JEROBOAM(2835),
    REHOBOAM(4309),
    BORDEAUX_JEROBOAM(4820),
    OLD_BORDEAUX_JEROBOAM(4253),
    IMPERIAL(5800),
    SALMANZAR(8620),
    BALTHAZAR(11520),
    NEBUCHANEZZAR(14400),
    MELCHIOR(17300),
    SOLOMON(19200),
    SOVEREIGN(24000),
    GOLIATH(25900),
    MELCHIZEDEK(28750),
    MAXIMUS(132500);

    private int weight;

    BottleType(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public static BottleType parse(String name) {
        for (BottleType type : BottleType.values()) {
            if (type.name().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }
}
