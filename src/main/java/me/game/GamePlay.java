package me.game;

import me.domain.BaseBallNumbers;
import me.domain.GameStatus;
import me.domain.InputNumbers;
import me.predicate.ScoreValidator;

public class GamePlay {
    private final BaseBallNumbers baseBallNumbers = BaseBallNumbers.getInstance();
    private static final int GAME_COUNT = 7;
    private static final String WIN_MESSAGE = "정답을 맞췄습니다. 게임이 종료됩니다.";
    private static final String DEFEAT_MESSAGE = "주어진 기회를 모두 사용하셨습니다. \n게임이 종료됩니다.";

    public GamePlay() {
        start();
    }

    public void start() {
        System.out.println(baseBallNumbers.getBaseBallNumbers().toString());
        GameStatus gameStatus = new GameStatus();

        int count = 0;
        while (count < GAME_COUNT) {
            InputNumbers inputNumbers = null;

            try {
                inputNumbers = new InputNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            validateGameStatus(inputNumbers , gameStatus);
            count++;
        }

        gameOver();
    }

    private void validateGameStatus(InputNumbers inputNumbers , GameStatus gameStatus) {
        ScoreValidator scoreValidator = new ScoreValidator(inputNumbers , gameStatus);
        scoreValidator.execute();
        gameStatusCheck(gameStatus);
        gameStatus.clear();
    }

    private void gameStatusCheck(GameStatus gameStatus) {
        System.out.println(gameStatus.toString());

        if (gameStatus.getStrikePoint() == 3) {
            System.out.println(WIN_MESSAGE);
            System.exit(0);
        }
    }

    private void gameOver() {
        System.out.println(DEFEAT_MESSAGE);
        System.exit(0);
    }
}
