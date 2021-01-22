import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToeConsoleApp {

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.playGame();
    }
}
