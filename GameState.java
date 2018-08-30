public interface GameState
{
    public boolean conditionsMet(int x, int y, int ans);
    public boolean isGameOver();
    public void setBoard(int row, int col, int val);
    public String toString();
}
