public class MainMenu extends MenuContainer {

    private MonsterDB monsterDB = new MonsterDB();

    public MainMenu() {
        this.addSubMenu(new ProfileMenu(monsterDB));
        this.addSubMenu(new MonsterRace(monsterDB));
    }
}
