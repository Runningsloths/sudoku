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
    //takes too long

        List<Integer> vals = Arrays.asList(1,2,3,4,5,6,7,8,9);
        int counter = 1;
        Collections.shuffle(vals);
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[0][i] = vals.get(i);
        }
        while (counter < BOARD_SIZE) {
            boolean hasZeros = false;
            for (int i = 0; i < BOARD_SIZE; i++) {
                board[counter][i] = 0;
            }
            Collections.shuffle(vals);
            for (int i = 0; i < BOARD_SIZE; i++) {
                if (conditionsMet(counter, i, vals.get(i))) {
                    setBoard(counter, i, vals.get(i));
                }
                else {
                    break;
                }
            }
            for (int i : board[counter]) {
                if (i == 0) {
                    hasZeros = true;
                }
            }
            if (!hasZeros) {
                counter++;
            }
            System.out.println(toString());
            //System.out.println("Percent finished: " + Math.ceil((((double)counter / BOARD_SIZE) * 100)));
        }

    //doesnt consider conditions before placing
        // int counter = 0;
        // while (counter < 9) {
        //     for (int i = 0; i < BOARD_SIZE; i++) {
        //         int temp = new Random().nextInt(10);
        //         System.out.println(temp + toString());
        //         if (conditionsMet(counter, i, temp)) {
        //             board[counter][i] = temp;
        //         }
        //         else {
        //             i--;
        //         }
        //     }
        //     counter++;
        // }

    //missing checks for rows and cols
        // List<Integer> vals = Arrays.asList(1,2,3,4,5,6,7,8,9);
        // int counter = 0;
        // while (counter < 40) {
        //     Collections.shuffle(vals);
        //     for (int i = 0; i < BOARD_SIZE / 3; i++) {
        //         for (int j = 0; j < BOARD_SIZE / 3; j++) {
        //             if (conditionsMet(i, j, vals.get(counter % 9))) {
        //                 board[i][j] = vals.get(counter % 9);
        //                 counter++;
        //             }
        //             else if (conditionsMet(i+3, j, vals.get(counter % 9))) {
        //                 board[i+3][j] = vals.get(counter % 9);
        //                 counter++;
        //             }
        //         }
        //     }
        //     System.out.println(toString());
        // }
        removeNums();
    }
    private void removeNums()
    {
        for (int i = 0; i < BOARD_SIZE * 5; i++) {
            int tempRow = new Random().nextInt(9);
            int tempCol = new Random().nextInt(9);
            if (board[tempRow][tempCol] != 0) {
                board[tempRow][tempCol] = 0;
            }
            else {
                i--;
            }
        }
    }
    public boolean conditionsMet(int row, int col, int ans)
    {
        if (ans == 0) return true;
        if (ans > 9 || ans < 0) {
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
