import java.util.ArrayList;
import java.util.List;

public class BaseBallNumber {
    private final List<Integer> numbers;
    private static final int NUMBER_SIZE = 3;

    public BaseBallNumber() {
        this.numbers = createBaseBallNumber();
    }

    private List<Integer> createBaseBallNumber() {
        List<Integer> numbers = new ArrayList<>(NUMBER_SIZE);
        while (true) {
            if (numbers.size() == 3) break;
            int number = (int)(Math.random() * 9) + 1;
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }

        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
