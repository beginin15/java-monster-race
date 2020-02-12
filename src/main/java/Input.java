import java.util.Scanner;

public class Input {

    private static Scanner scanner = new Scanner(System.in);

    private Input() { }

    public static int selectNumberOfMenu(int menuRange) {
        String message = String.format("원하는 메뉴를 선택해 주세요(1 - %d)", menuRange);
        System.out.println(message);
        return getIntOfSpecificRange(0, menuRange);
    }

    public static void getExitCode() {
        System.out.println("종료하려면 아무 키 + Enter를 입력해주세요.");
        scanner.nextLine();
    }

    public static Monster getNewMonster() {
        System.out.println("몬스터 이름과 종류를 입력하세요. (쉼표(,)를 기준으로 구분)");
        Monster monster = null;
        try {
            monster = createMonster();
        } catch (InvalidDelimiterException | UnknownMonsterTypeException e) {
            System.out.println(e.getMessage());
        }
        return monster;
    }

    public static String[] getNewProfile() {
        System.out.println("새로운 이름과 종류를 입력하세요. (쉼표(,)를 기준으로 구분)");
        return getProfileOfMonster();
    }

    public static int getRounds() {
        System.out.println("몇 라운드?");
        return getPositiveInt();
    }

    public static void closeScanner() {
        if (scanner != null)
            scanner.close();
    }

    // 파라미터 : min (미포함), max (포함)
    private static int getIntOfSpecificRange(int min, int max) {
        int input;
        try {
            input = Integer.parseInt(scanner.nextLine());
            if (input <= min || input > max)
                throw new InvalidRangeException("유효 범위에서 벗어난 입력값입니다.");
        } catch (NumberFormatException | InvalidRangeException e) {
            System.out.println(e.getMessage());
            input = getIntOfSpecificRange(min, max);
        }
        return input;
    }

    private static int getPositiveInt() {
        int input;
        try {
            input = Integer.parseInt(scanner.nextLine());
            if (input <= 0)
                throw new InvalidRangeException("유효 범위에서 벗어난 입력값입니다.");
        } catch (NumberFormatException | InvalidRangeException e) {
            System.out.println(e.getMessage());
            input = getPositiveInt();
        }
        return input;
    }

    private static Monster createMonster() throws InvalidDelimiterException, UnknownMonsterTypeException {
        final int indexOfName = 0;
        final int indexOfType = 1;

        String[] monsterProfile = getProfileOfMonster();
        if (monsterProfile.length <= indexOfType)
            throw new InvalidDelimiterException("잘못된 구분자입니다.");

        Monster monster = MonsterFactory.getMonsterInstance(monsterProfile[indexOfName], monsterProfile[indexOfType]);
        if (monster == null)
            throw new UnknownMonsterTypeException("존재하지 않는 몬스터 타입입니다.");
        return monster;
    }

    private static String[] getProfileOfMonster() {
        String input = scanner.nextLine().replaceAll(" ", "");
        return input.split(",");
    }

    private static class InvalidRangeException extends RuntimeException {

        public InvalidRangeException(String message) {
            super(message);
        }
    }

    private static class InvalidDelimiterException extends RuntimeException {

        public InvalidDelimiterException(String message) {
            super(message);
        }
    }

    private static class UnknownMonsterTypeException extends RuntimeException {

        public UnknownMonsterTypeException(String message) {
            super(message);
        }
    }
}