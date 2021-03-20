public class GameStatus {
    private Status strike;
    private Status ball;
    private Status out;

    public GameStatus() {
        this.strike = Status.STRIKE;
        this.ball = Status.BALL;
        this.out = Status.OUT;
    }

    public void strike() {
        this.strike.plus();
    }

    public void ball() {
        this.ball.plus();
    }

    public void out() {
        this.out.plus();
    }

    @Override
    public String toString() {
        return strike.getPoint() + " " + strike.toString() + " , "
                + ball.getPoint() + " " + ball.toString() + " , "
                + out.getPoint() + " " + out.toString();
    }
}
