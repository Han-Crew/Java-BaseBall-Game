import domain.InputNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InputNumbersTest {

    @Mock
    private InputNumbers inputNumbers;

    @Test
    @DisplayName("정상적으로 숫자가 생성된 경우")
    public void create_inputNumbers() {
        when(inputNumbers.getInputNumbers())
                .thenReturn(List.of(1 , 2 , 3));

        assertThat(inputNumbers.getInputNumbers()).isEqualTo(List.of(1,2,3));

        verify(inputNumbers , times(1)).getInputNumbers();
    }
}
