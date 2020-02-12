public enum Type {
    NORMAL("노말", 1, 4),
    FLYING("비행", 3, 6),
    PSYCHIC("에스퍼", 0, 9);

    private final String typeName;
    private int speed;
    private int randomLimit;

    Type(String typeName, int speed, int randomLimit) {
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
}
