public class MiniMaxMovesAnalysis {
    public static void main(String[] args) {
            Board board = new Board();
            MiniMax minimax = new MiniMax();
            int availableTiles = 9;
            for (int row = 0; row < board.getWidth(); row++) {
                for (int col = 0; col < board.getWidth(); col++) {
                    long startTime = System.nanoTime();
                    board.placeMark(row, col);
                    minimax.getBestMove(board, 6);
                    long endTime   = System.nanoTime();
                    long totalTime = endTime - startTime;
                    availableTiles -= 1;
                    System.out.println("Available tiles: "+ availableTiles + " " + "μs: " + totalTime / 1000 + "\n" + "Used memory(MB): " + (getUsedMemory() / 1000000));
                }
            }
    }

    public static long getUsedMemory() {
        return Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
    }
}
