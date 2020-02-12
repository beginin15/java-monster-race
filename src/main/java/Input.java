import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);

    public int getCountOfMonsters() {
        System.out.println("출전할 몬스터는 몇 마리?");
        return getPositiveInt();
    }

    public List<Monster> getParticipants(int countOfMonsters) {
        System.out.println("경주할 몬스터 이름과 종류를 입력하세요. (쉼표(,)를 기준으로 구분)");
        List<Monster> monsters = new ArrayList<>();
        while (monsters.size() != countOfMonsters) {
            try {
                monsters.add(createMonster());
            } catch (InvalidDelimiterException | UnknownMonsterTypeException e) {
                System.out.println(e.getMessage());
            }
        }
        return monsters;
    }

    public int getRounds() {
        System.out.println("몇 라운드?");
        return getPositiveInt();
    }

    public void closeScanner() {
        if (scanner != null)
            scanner.close();
    }

    private int getPositiveInt() {
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

    private Monster createMonster() throws InvalidDelimiterException, UnknownMonsterTypeException {
        final int indexOfName = 0;
        final int indexOfType = 1;

        String[] monsterInfo = getMonsterInfo();
        if (monsterInfo.length <= indexOfType)
            throw new InvalidDelimiterException("잘못된 구분자입니다.");

        Monster monster = MonsterFactory.getMonsterInstance(monsterInfo[indexOfName], monsterInfo[indexOfType].trim());
        if (monster == null)
            throw new UnknownMonsterTypeException("존재하지 않는 몬스터 타입입니다.");
        return monster;
    }

    private String[] getMonsterInfo() {
        String input = scanner.nextLine().trim();
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
