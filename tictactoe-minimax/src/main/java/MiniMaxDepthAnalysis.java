public class MiniMaxDepthAnalysis {
    public static void main(String[] args) {
        for(int i = 1; i < 7; i++){
            long startTime = System.nanoTime();
            MiniMax miniMax = new MiniMax();
            Board board = new Board();
            miniMax.getBestMove(board, i);
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println("Depth: " + i + " " + "μs: " + totalTime / 1000 + "\n" + "Used memory(MB): " + (getUsedMemory() / 1000000));
        }
    }

    public static long getUsedMemory() {
        return Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
    }
}
