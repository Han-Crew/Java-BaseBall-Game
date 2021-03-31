package me.predicate;

import me.domain.GameStatus;
import me.domain.InputNumbers;
import me.predicate.impl.BallPredicate;
import me.predicate.impl.OutPredicate;
import me.predicate.impl.StrikePredicate;

import java.util.List;

public class ScoreValidator {
    private final InputNumbers inputNumbers;
    private final List<ScorePredicate> scorePredicateList;

    public ScoreValidator(InputNumbers inputNumbers , GameStatus gameStatus) {
        this.inputNumbers = inputNumbers;
        this.scorePredicateList = List.of(
                new StrikePredicate(gameStatus),
                new BallPredicate(gameStatus),
                new OutPredicate(gameStatus)
        );
    }

    public void execute() {
        scorePredicateList.forEach(scorePredicate -> scorePredicate.execute(inputNumbers));
    }
}
