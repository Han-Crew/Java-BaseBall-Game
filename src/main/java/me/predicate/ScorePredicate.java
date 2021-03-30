package me.predicate;

import me.domain.InputNumbers;

@FunctionalInterface
public interface ScorePredicate {
    void execute(InputNumbers inputNumbers);
}
