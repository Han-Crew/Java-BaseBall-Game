package predicate.impl;

import domain.BaseBallNumbers;
import domain.GameStatus;
import domain.InputNumbers;
import predicate.ScorePredicate;

public class StrikePredicate implements ScorePredicate {
    private final BaseBallNumbers baseBallNumbers = BaseBallNumbers.getInstance();
    private final GameStatus gameStatus;

    public StrikePredicate(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    @Override
    public void execute(InputNumbers inputNumbers) {
        for (int i=0; i< inputNumbers.size(); i++) {
            if (inputNumbers.getNumber(i) == baseBallNumbers.getNumber(i)) {
                gameStatus.strike();
            }
        }
    }
}
