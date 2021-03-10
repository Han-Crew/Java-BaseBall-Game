package game;

public enum GameStatus {
    BALL("숫자는 맞지만 위치가 틀림"),
    STRIKE("숫자와 위치가 모두 맞음"),
    OUT("숫자와 위치가 모두 틀림");


    GameStatus(String description) {
        this.description = description;
    }

    private final String description;

    public String getDescription() {
        return description;
    }
}
