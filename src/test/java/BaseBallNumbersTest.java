import domain.BaseBallNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class BaseBallNumbersTest {

    @Mock
    private BaseBallNumbers baseBallNumbers;

    @Test
    @DisplayName("BaseBallNumbers 객체 숫자생성 확인")
    void numberCreateTest() {
        BaseBallNumbers baseBallNumbers = BaseBallNumbers.getInstance();
        assertThat(baseBallNumbers.getBaseBallNumbers().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("BaseBallNumbers 싱글턴 객체라면 성공해야 한다")
    void singletonObjectTest() {
        BaseBallNumbers firstBaseBallNumbers = BaseBallNumbers.getInstance();
        BaseBallNumbers secondBaseBallNumbers = BaseBallNumbers.getInstance();

        assertThat(firstBaseBallNumbers.hashCode()).isEqualTo(secondBaseBallNumbers.hashCode());
        assertThat(firstBaseBallNumbers.hashCode()).isNotEqualTo(baseBallNumbers.getClass());
        assertThat(secondBaseBallNumbers.hashCode()).isNotEqualTo(baseBallNumbers.getClass());
    }


}
