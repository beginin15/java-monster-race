public class ProfileMenu extends MenuContainer {

    private MonsterDB monsterDB;

    public ProfileMenu(MonsterDB monsterDB) {
        this.monsterDB = monsterDB;
        initializeMenus();
    }

    private void initializeMenus() {
        addSubMenu(createShowMonstersMenu());
        addSubMenu(createModifyMonsterMenu());
        addSubMenu(createNewMonsterMenu());
        addSubMenu(createDeleteMonsterMenu());
        addSubMenu(createExitMenu());
    }

    private MenuItem createShowMonstersMenu() {
        return new MenuItem() {
            @Override
            public void execute() {
                monsterDB.showMonsterList();
                Input.getExitCode();
            }

            @Override
            public String toString() {
                return "전체 몬스터 정보 보기";
            }
        };
    }

    private MenuItem createModifyMonsterMenu() {
        return new MenuItem() {
            @Override
            public void execute() {
                Monster comparatorMonster = Input.getNewMonster();
                String[] newProfile = Input.getNewProfile();
                modify(comparatorMonster, newProfile);
            }

            @Override
            public String toString() {
                return "몬스터 정보 수정";
            }

            private void modify(Monster comparatorMonster, String[] newProfile) {
                final int indexOfName = 0;
                final int indexOfType = 1;
                String name = newProfile[indexOfName];
                Type type = Type.parseType(newProfile[indexOfType]);
                if (!monsterDB.modifyMonster(comparatorMonster, name, type))
                    System.out.println("존재하지 않는 몬스터입니다.");
            }
        };
    }

    private MenuItem createNewMonsterMenu() {
        return new MenuItem() {
            @Override
            public void execute() {
                Monster newMonster = Input.getNewMonster();
                if (!monsterDB.addMonster(newMonster))
                    System.out.println("이미 참가한 몬스터입니다.");
            }

            @Override
            public String toString() {
                return "새로운 몬스터 정보 입력";
            }
        };
    }

    private MenuItem createDeleteMonsterMenu() {
        return new MenuItem() {
            @Override
            public void execute() {
                Monster comparatorMonster = Input.getNewMonster();
                if (!monsterDB.deleteMonster(comparatorMonster))
                    System.out.println("존재하지 않는 몬스터입니다.");
            }

            @Override
            public String toString() {
                return "몬스터 정보 삭제";
            }
        };
    }

    private MenuItem createExitMenu() {
        return new MenuItem() {
            @Override
            public void execute() {
                isExit = true;
            }

            @Override
            public String toString() {
                return "이전 메뉴로";
            }
        };
    }

    @Override
    public String toString() {
        return "몬스터 정보";
    }
}
