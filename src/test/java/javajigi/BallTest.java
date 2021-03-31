package javajigi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    private Ball com;

    @BeforeEach
    void setUp() {
        com = new Ball(1 , 4);
    }

    @Test
    void STRIKE() {
        BallStatus status = com.play(new Ball(1 , 4));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void BALL() {
        BallStatus status = com.play(new Ball(2 , 4));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void OUT() {
        BallStatus status = com.play(new Ball(2 , 5));
        assertThat(status).isEqualTo(BallStatus.OUT);
    }
}
