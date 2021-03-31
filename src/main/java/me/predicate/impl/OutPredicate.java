package me.predicate.impl;

import me.domain.BaseBallNumbers;
import me.domain.GameStatus;
import me.domain.InputNumbers;
import me.predicate.ScorePredicate;

public class OutPredicate implements ScorePredicate {
    private final BaseBallNumbers baseBallNumbers = BaseBallNumbers.getInstance();
    private final GameStatus gameStatus;

    public OutPredicate(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    @Override
    public void execute(InputNumbers inputNumbers) {
        for (int i=0; i < inputNumbers.size(); i++) {
            int inputNumber = inputNumbers.getNumber(i);
            if (isEqualsNumber(inputNumber, i) &&
                    !baseBallNumbers.contains(inputNumber)) {
                gameStatus.out();
            }
        }
    }

    private boolean isEqualsNumber(int inputNumber , int index) {
        return inputNumber != baseBallNumbers.getNumber(index);
    }
}
