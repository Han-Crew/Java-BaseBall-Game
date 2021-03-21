package predicate;

import domain.InputNumbers;

@FunctionalInterface
public interface ScorePredicate {
    void execute(InputNumbers inputNumbers);
}
