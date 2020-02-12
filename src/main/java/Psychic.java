public class Psychic extends Monster {

    public Psychic(String monsterName, Type type) {
        super(monsterName, type);
    }

    @Override
    public void update() {
        if (isForward())
            this.traces += castingSpeedDice();
    }

    @Override
    public boolean isForward() {
        int diceNumber = castingDice();
        return diceNumber == type.getRandomLimit();
    }

    private int castingSpeedDice() {
        return (int)(Math.random() * 20) + 1;
    }
}
