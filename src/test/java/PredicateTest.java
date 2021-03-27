import domain.GameStatus;
import domain.InputNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import predicate.ScoreValidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PredicateTest {
    @Mock
    private InputNumbers inputNumbers;

    @Nested
    @DisplayName("구현한 Predicate 의 개별 메서드 동작 테스트")
    class PredicateOperatorTest {
        @BeforeEach
        void init() {
            when(inputNumbers.size()).thenReturn(3);
            lenient().when(inputNumbers.getNumber(0)).thenReturn(1);
            lenient().when(inputNumbers.getNumber(1)).thenReturn(2);
            lenient().when(inputNumbers.getNumber(2)).thenReturn(3);
        }

        @Test
        @DisplayName("Strike Predicate 정상적으로 동작하는지")
        void strikePredicateTest() {
            GameStatus gameStatus = new GameStatus();
            ScoreValidator scoreValidator = new ScoreValidator(inputNumbers , gameStatus);
            scoreValidator.execute();

            if (gameStatus.getStrikePoint() > 0) {
                assertThat(gameStatus.getStrikePoint()).isGreaterThan(0);
            } else {
                assertThat(gameStatus.getStrikePoint()).isEqualTo(0);
            }
        }

        @Test
        @DisplayName("Ball Predicate 정상적으로 동작하는지")
        void ballPredicateTest() {
            GameStatus gameStatus = new GameStatus();
            ScoreValidator scoreValidator = new ScoreValidator(inputNumbers , gameStatus);
            scoreValidator.execute();

            gameStatus.ball();
            assertThat(gameStatus.getBallPoint()).isGreaterThan(0);
        }

        @Test
        @DisplayName("Out Predicate 정상적으로 동작하는지")
        void outPredicateTest() {
            GameStatus gameStatus = new GameStatus();
            ScoreValidator scoreValidator = new ScoreValidator(inputNumbers , gameStatus);
            scoreValidator.execute();

            gameStatus.out();
            assertThat(gameStatus.getOutPoint()).isGreaterThan(0);
        }
    }
}
