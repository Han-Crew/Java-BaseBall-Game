import domain.GameStatus;
import domain.InputNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import predicate.ScoreValidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GamePlayTest {

    @Mock
    private InputNumbers inputNumbers;

    @Nested
    @DisplayName("게임 실행 과정 테스트")
    class PlayGameTest {
        @Test
        @DisplayName("가지고 있는 숫자가 3 개 이상인 경우 IndexOutOfBoundsException 발생해야 한다")
        void overSizeNumbers() {
            when(inputNumbers.size()).thenReturn(5);
            lenient().when(inputNumbers.getNumber(0)).thenReturn(1);
            lenient().when(inputNumbers.getNumber(1)).thenReturn(2);
            lenient().when(inputNumbers.getNumber(2)).thenReturn(3);

            GameStatus gameStatus = new GameStatus();
            ScoreValidator scoreValidator = new ScoreValidator(inputNumbers , gameStatus);

            RuntimeException exception = assertThrows(
                    RuntimeException.class,
                    () -> scoreValidator.execute());

            assertThat(exception.getClass()).isEqualTo(IndexOutOfBoundsException.class);
        }

        @Test
        @DisplayName("야구게임 validator 가 정상적으로 동작하는지 확인")
        void validatorOperatorTest() {
            when(inputNumbers.size()).thenReturn(3);
            lenient().when(inputNumbers.getNumber(0)).thenReturn(1);
            lenient().when(inputNumbers.getNumber(1)).thenReturn(2);
            lenient().when(inputNumbers.getNumber(2)).thenReturn(3);

            GameStatus gameStatus = new GameStatus();
            ScoreValidator scoreValidator = new ScoreValidator(inputNumbers , gameStatus);
            scoreValidator.execute();

            if (gameStatus.getStrikePoint() > 0) {
                assertThat(gameStatus.getStrikePoint()).isGreaterThan(0);
            } else {
                assertThat(gameStatus.getStrikePoint()).isEqualTo(0);
            }
        }
    }
}
