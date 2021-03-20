public class BaseBallApplication {
    public static void main(String[] args) {
        BaseBallNumber baseBallNumber = new BaseBallNumber();
        GameStatus gameStatus = new GameStatus();

        Game game = new Game(baseBallNumber , gameStatus);
    }
}
