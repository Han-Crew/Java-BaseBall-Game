package me.predicate.impl;

import me.domain.BaseBallNumbers;
import me.domain.GameStatus;
import me.domain.InputNumbers;
import me.predicate.ScorePredicate;

public class BallPredicate implements ScorePredicate {
    private final BaseBallNumbers baseBallNumbers = BaseBallNumbers.getInstance();
    private final GameStatus gameStatus;

    public BallPredicate(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    @Override
    public void execute(InputNumbers inputNumbers) {
        for (int i=0; i < inputNumbers.size(); i++) {
            int inputNumber = inputNumbers.getNumber(i);
            if (isNotEqualsNumber(inputNumber, i) &&
                    baseBallNumbers.contains(inputNumber)) {
                gameStatus.ball();
            }
        }
    }

    private boolean isNotEqualsNumber(int inputNumber , int index) {
        return inputNumber != baseBallNumbers.getNumber(index);
    }
}
