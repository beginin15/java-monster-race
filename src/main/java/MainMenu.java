public class MainMenu extends MenuContainer {

    private MonsterDB monsterDB = MonsterDB.getInstance();

    private MainMenu() {
        addSubMenu(ProfileMenu.getInstance());
        addSubMenu(new MonsterRace());
    }

    public static MenuContainer getInstance() {
        if(instance == null)
            instance = new MainMenu();
        return instance;
    }
}
