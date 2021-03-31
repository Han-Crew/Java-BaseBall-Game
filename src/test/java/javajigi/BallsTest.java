package javajigi;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {
    @Test
    void play_out() {
        Balls answers = new Balls(List.of(1 , 2 , 3));
        PlayResult result = answers.play(List.of(4 , 5 , 6));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void play_1strike_1ball() {
        Balls answers = new Balls(List.of(1 , 2 , 3));
        PlayResult result = answers.play(List.of(1 , 4 , 2));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void play_3strike() {
        Balls answers = new Balls(List.of(1 , 2 , 3));
        PlayResult result = answers.play(List.of(1 , 2 , 3));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isGameEnd()).isTrue();
    }

    @Test
    void STRIKE() {
        Balls answers = new Balls(List.of(1 , 2 , 3));
        BallStatus status = answers.play(new Ball(1 , 1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void BALL() {
        Balls answers = new Balls(List.of(1 , 2 , 3));
        BallStatus status = answers.play(new Ball(1 , 2));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void OUT() {
        Balls answers = new Balls(List.of(1 , 2 , 3));
        BallStatus status = answers.play(new Ball(1 , 4));
        assertThat(status).isEqualTo(BallStatus.OUT);
    }
}
