import java.util.ArrayList;
import java.util.List;

public class MenuContainer implements MenuItem {

    protected boolean isExit = false;
    protected static MenuContainer instance;
    private List<MenuItem> menuItems = new ArrayList<>();

    @Override
    public void execute() {
        do {
            showMenus();
            MenuItem selectedMenu = selectMenu();
            selectedMenu.execute();
        } while (!isExit);
        isExit = false;
    }

    protected void addSubMenu(MenuItem subMenu) {
        menuItems.add(subMenu);
    }

    private void showMenus() {
        for (int i = 0; i < menuItems.size(); i++) {
            String menu = String.format("%d. %s", i + 1, menuItems.get(i));
            System.out.println(menu);
        }
    }

    private MenuItem selectMenu() {
        int numberOfMenu = Input.selectNumberOfMenu(menuItems.size());
        return menuItems.get(numberOfMenu - 1);
    }
}
