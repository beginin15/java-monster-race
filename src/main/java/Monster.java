public abstract class Monster {

    private static final int RANDOM_MAX = 10;
    private String monsterName;
    protected Type type;
    protected int traces;

    public Monster(String monsterName, Type type) {
        this.monsterName = monsterName;
        this.type = type;
    }

    abstract public void update();

    public void render() {
        System.out.println(this + " : " + getTraces2String());
    }

    public int getTraces() {
        return traces;
    }

    @Override
    public String toString() {
        return String.format("%s [%s]", this.monsterName, this.type.getTypeName());
    }

    protected boolean isForward() {
        int diceNumber = castingDice();
        return diceNumber >= type.getRandomLimit();
    }

    protected int castingDice() {
        return (int)(Math.random() * RANDOM_MAX);
    }

    private String getTraces2String() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.traces; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
