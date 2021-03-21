package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputNumbers {
    private final List<Integer> inputNumbers;
    private static final int INPUT_NUMBERS_SIZE = 3;

    public InputNumbers() {
        this.inputNumbers = createInputNumbers();
    }

    private List<Integer> createInputNumbers() {
        Scanner in = new Scanner(System.in);
        List<Integer> inputNumbers = null;

        try {
            inputNumbers = Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            validateInputNumberSize(inputNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력하여야 합니다.");
        }

        return inputNumbers;
    }

    private void validateInputNumberSize(List<Integer> inputNumbers) {
        if (inputNumbers.size() != INPUT_NUMBERS_SIZE) {
            throw new IllegalArgumentException("3개의 숫자만 입력할수 있습니다.");
        }
    }

    public List<Integer> getInputNumbers() {
        return inputNumbers;
    }

    public int size() {
        return inputNumbers.size();
    }

    public int getNumber(int index) {
        return inputNumbers.get(index);
    }
}
