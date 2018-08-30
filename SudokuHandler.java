public class SudokuHandler implements GameState
{
    public static final int BOARD_SIZE = 9;
    private int[][] board;

    public SudokuHandler(int[][] _board) 
    {
    	board = _board;
    }
    public boolean conditionsMet(int row, int col, int ans)
    {
    	if (row > 0 && row < 10 && col > 0 && col < 10) {
    		for (int i = 0; i < BOARD_SIZE; i++) {
    			if (board[row][i] == ans || board[i][col] == ans) {
    				return false;
    			}
    		}
			int newRow = row + 1, newCol = col + 1;
			int startRow = newRow - (newRow % 3), startCol = newCol - (newCol % 3);
			for (int i = startRow; i < startRow + 3; i++) {
				for (int j = startCol; j < startCol + 3; j++) {
					if (board[i][j] == ans) {
						return false;
					}
				}
			}
			return true;
    	}
    	return false;
    }
    public boolean isGameOver()
    {
    	for (int i = 0; i < BOARD_SIZE; i++) {
    		for (int j = 0; j < BOARD_SIZE; j++) {
    			if (board[i][j] == 0) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    public void setBoard(int a, int b, int c)
    {
    	board[a][b] = c;
    }
    public String toString()
    {
    	String temp = "   1 2 3   4 5 6   7 8 9\n__________________________\n";
    	for (int i = 0; i < BOARD_SIZE; i++) {
    		temp += (i + 1) + "| ";
    		for (int j = 0; j < BOARD_SIZE; j++) {
    			temp += board[i][j] + " ";
    			if (j > 0 && j % 3 == 2) {
    				temp += "| ";
    			}
    		}
    		temp += "\n";
    		if (i != 0 && i % 3 == 2) {
    			temp += "--------------------------\n";
    		}
    	}
    	return temp;
    }
}
