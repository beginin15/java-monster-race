import java.util.Objects;

public abstract class Monster {

    public static final int RANDOM_MAX = 10;
    protected Type type;
    protected int traces;
    private String monsterName;

    public Monster(String monsterName, Type type) {
        this.monsterName = monsterName;
        this.type = type;
    }

    abstract public void update();

    public void render() {
        System.out.println(this + " : " + getTraces2String());
    }

    @Override
    public String toString() {
        return String.format("%s [%s]", this.monsterName, this.type.getTypeName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return type == monster.type &&
                Objects.equals(monsterName, monster.monsterName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, monsterName);
    }

    public int getTraces() {
        return traces;
    }

    public String getProfile() {
        return monsterName + type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
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
