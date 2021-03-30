package me.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseBallNumbers {
    private final List<Integer> baseBallNumbers;
    private static final int BASEBALL_NUMBER_SIZE = 3;

    private BaseBallNumbers() {
        this.baseBallNumbers = createBaseBallNumber();
    }

    private static class LazyHolder {
        private static BaseBallNumbers instance = new BaseBallNumbers();
    }

    public static BaseBallNumbers getInstance() {
        return LazyHolder.instance;
    }

    private List<Integer> createBaseBallNumber() {
        List<Integer> baseBallNumbers = new ArrayList<>(BASEBALL_NUMBER_SIZE);
        while (true) {
            if (baseBallNumbers.size() == 3) break;
            int number = (int)(Math.random() * 9) + 1;
            if (!baseBallNumbers.contains(number)) {
                baseBallNumbers.add(number);
            }
        }

        return baseBallNumbers;
    }

    public List<Integer> getBaseBallNumbers() {
        return baseBallNumbers;
    }

    public int getNumber(int index) {
        return baseBallNumbers.get(index);
    }

    public boolean contains(int number) {
        return baseBallNumbers.contains(number);
    }
}
