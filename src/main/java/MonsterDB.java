import java.util.ArrayList;
import java.util.List;

public class MonsterDB {

    private static MonsterDB instance;
    private List<Monster> monsters = new ArrayList<>();

    private MonsterDB() { }

    public static MonsterDB getInstance() {
        if(instance == null)
            instance = new MonsterDB();
        return instance;
    }

    public void showMonsterList() {
        if (monsters.size() == 0) {
            System.out.println("-- 비 어 있 음 --");
            return;
        }
        for (Monster monster : monsters) {
            System.out.println(monster.getProfile());
        }
    }

    public boolean modifyMonster(Monster comparatorMonster, String newName, Type newType) {
        int index = monsters.indexOf(comparatorMonster);
        if(index == -1)
            return false;
        comparatorMonster.setMonsterName(newName);
        comparatorMonster.setType(newType);
        monsters.set(index, comparatorMonster);
        return true;
    }

    public boolean addMonster(Monster newMonster) {
        if (monsters.contains(newMonster))
            return false;
        monsters.add(newMonster);
        return true;
    }

    public boolean deleteMonster(Monster comparatorMonster) {
        return monsters.remove(comparatorMonster);
    }
}
