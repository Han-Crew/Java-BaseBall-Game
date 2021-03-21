package game;

import domain.BaseBallNumbers;
import domain.GameStatus;
import domain.InputNumbers;
import predicate.ScoreValidator;

public class GamePlay {
    private final BaseBallNumbers baseBallNumbers = BaseBallNumbers.getInstance();
    private static final int GAME_COUNT = 7;

    public GamePlay() {
        start();
    }

    public void start() {
        System.out.println(baseBallNumbers.getBaseBallNumbers().toString());
        GameStatus gameStatus = new GameStatus();

        for (int i=0; i < GAME_COUNT; i++) {
            InputNumbers inputNumbers = new InputNumbers();
            ScoreValidator scoreValidator = new ScoreValidator(inputNumbers , gameStatus);
            scoreValidator.execute();
            gameStatusCheck(gameStatus);
            gameStatus.clear();
        }

        gameOver();
    }

    private void gameStatusCheck(GameStatus gameStatus) {
        System.out.println(gameStatus.toString());

        if (gameStatus.getStrikePoint() == 3) {
            System.out.println("정답을 맞췄습니다. 게임이 종료됩니다.");
            System.exit(0);
        }
    }

    private void gameOver() {
        System.out.println("주어진 기회를 모두 사용하셨습니다.");
        System.out.println("게임이 종료됩니다.");
        System.exit(0);
    }
}
