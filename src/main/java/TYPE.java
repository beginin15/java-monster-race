public enum Type {
    NORMAL("노말", 1, 4),
    FLYING("비행", 3, 6),
    PSYCHIC("에스퍼", 0, 9);

    private final String typeName;
    private int speed;
    private int randomLimit;

    private Type(String typeName, int speed, int randomLimit) {
        this.typeName = typeName;
        this.speed = speed;
        this.randomLimit = randomLimit;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getSpeed() {
        return speed;
    }

    public int getRandomLimit() {
        return randomLimit;
    }

    @Override
    public String toString() {
        int forwardPercentage = (Monster.RANDOM_MAX - randomLimit) * 10;
        return String.format("[ %s 타입 / 속도 : %s / 이동 확률 : %s ]", typeName, speed, forwardPercentage);
    }

    public static Type parseType(String typeName) {
        switch (typeName) {
            case "노말" :
                return Type.NORMAL;
            case "비행" :
                return Type.FLYING;
            case "에스퍼" :
                return Type.PSYCHIC;
        }
        return null;
    }
}

