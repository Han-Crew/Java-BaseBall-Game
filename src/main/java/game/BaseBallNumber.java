package game;

import java.util.List;

public class BaseBallNumber {
    private static final int BASEBALL_GAME_NUMBER_SIZE = 3;

    private final List<Integer> numbers;

    public BaseBallNumber(List<Integer> numbers) {
        validateSize(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != BASEBALL_GAME_NUMBER_SIZE) {
            throw new IllegalArgumentException("야구게임은 세개의 숫자만 가능합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < 0 || number > 9) {
                throw new IllegalArgumentException("야구게임은 0 ~ 9 사이의 숫자만 사용할 수 있습니다.");
            }
        });
    }
}
