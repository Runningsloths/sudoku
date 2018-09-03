import java.util.*;

public class SudokuHandler implements GameState
{
    public static final int BOARD_SIZE = 9;
    private int[][] board;

    public SudokuHandler(int[][] _board) 
    {
    	board = _board;
    }
    public void genBoard()
    {
        List<Integer> vals = Arrays.asList(1,2,3,4,5,6,7,8,9);
        int counter = 1;
        Collections.shuffle(vals);
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[0][i] = vals.get(i);
        }
        while (counter < BOARD_SIZE) {
            Collections.shuffle(vals);
            for (int i = 0; i < BOARD_SIZE; i++) {
                if (conditionsMet(counter, i, vals.get(i))) {
                    setBoard(counter, i, vals.get(i));
                }
                else {
                    break;
                }
            }
            if (IntStream.of(board[counter]).anyMatch(x -> x != 0)) {
                counter++;
            }
        }
    }
    public boolean conditionsMet(int row, int col, int ans)
    {
        if (ans > 9 && ans < 0) {
            return false;
        }
    	if (row >= 0 && row < 9 && col >= 0 && col < 9) {
    		for (int i = 0; i < BOARD_SIZE; i++) {
    			if (board[row][i] == ans || board[i][col] == ans) {
    				return false;
    			}
    		}
			int newRow = row, newCol = col;
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
                if (board[i][j] == 0) {
                    temp += "  ";
                }
                else {
                    temp += board[i][j] + " ";
                }
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
