package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static domain.ExceptionType.*;

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
            throw new IllegalArgumentException(REQUIRED_NUMBER_TYPES.getMessage());
        }

        return inputNumbers;
    }

    private void validateInputNumberSize(List<Integer> inputNumbers) {
        if (inputNumbers.size() != INPUT_NUMBERS_SIZE) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER_SIZE.getMessage());
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
