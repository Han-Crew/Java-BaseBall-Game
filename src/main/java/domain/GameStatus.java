package domain;

public class GameStatus {
    private final Status strike;
    private final Status ball;
    private final Status out;

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

    public void clear() {
        this.strike.clear();
        this.ball.clear();
        this.out.clear();
    }

    public int getStrikePoint() {
        return this.strike.getPoint();
    }

    @Override
    public String toString() {
        return strike.getPoint() + " " + strike.toString() + " , "
                + ball.getPoint() + " " + ball.toString() + " , "
                + out.getPoint() + " " + out.toString();
    }

    private enum Status {
        STRIKE(0),
        BALL(0),
        OUT(0);

        private int point;

        Status(int point) {
            this.point = point;
        }

        public void plus() {
            this.point++;
        }

        public int getPoint() {
            return point;
        }

        public void clear() {
            this.point = 0;
        }
    }
}
