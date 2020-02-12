import java.util.ArrayList;
import java.util.List;

public class MonsterRace implements MenuItem {

    private MonsterDB monsterDB = MonsterDB.getInstance();
    private List<Monster> monsters = new ArrayList<>();
    private int rounds;

    @Override
    public void execute() {

    }

    public void initialize() {
//        this.rounds = Input.getRounds();
//        int countOfMonsters = Input.getCountOfMonsters();
//        monsters = Input.getParticipants(countOfMonsters);
    }

    public void start() {
        System.out.println("<레이스 시작!>");
        for (int i = 1; i <= this.rounds; i++) {
            System.out.println("<" + i + "회>");
            updateRound();
            System.out.println();
        }
    }

    public void finish() {
        showWinners();
        Input.closeScanner();
    }

    @Override
    public String toString() {
        return "몬스터 경주 게임 시작";
    }

    private void updateRound() {
        for (Monster monster : monsters) {
            monster.update();
            monster.render();
        }
    }

    private void showWinners() {
        List<Monster> rankingList = rankParticipants();
        String namesOfWinners = listUpCoWinners(rankingList);
        System.out.println("축하합니다! " + namesOfWinners + "(이)가 몬스터 레이스에서 우승했습니다!");
    }

    private List<Monster> rankParticipants() {
        List<Monster> rankingList = new ArrayList<>(monsters);
        rankingList.sort((preMonster, nextMonster) -> nextMonster.getTraces() - preMonster.getTraces());
        return rankingList;
    }

    private String listUpCoWinners(List<Monster> rankingList) {
        final int WINNER = 0;
        int recordOfWinner = rankingList.get(WINNER).getTraces();
        return joinNamesOfCoWinners(recordOfWinner);
    }

    private String joinNamesOfCoWinners(int recordOfWinner) {
        return monsters.stream()
                .filter(monster -> recordOfWinner == monster.getTraces())
                .map(Monster::toString)
                .reduce("", (s1, s2)-> s1 + ", " + s2);
    }
}
