public enum Status {
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
}
