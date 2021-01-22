import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    public int turn;
    public Board board;
    public boolean playing = true;

    public Game(){
        turn = 1;
        board = new Board();
    }

    public void playGame() throws IOException {
        while(playing){
            if(turn == 2){
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Please insert x coordinate.");
                int x = Integer.parseInt(reader.readLine());
                System.out.println("Please insert y coordinate.");
                int y = Integer.parseInt(reader.readLine());
                board.placeMark(y, x);
                board.isCrossTurn();
                turn = 1;
            }
            if(turn == 1){
                int[] move = MiniMax.getBestMove(board, 6);
                int row = move[0];
                int col = move[1];
                board.placeMark(row, col);
                board.isCrossTurn();
                System.out.println(board);
                turn = 2;
                if(board.isGameOver() ==  true){
                    playing = false;
                }
            }
        }
    }
}
