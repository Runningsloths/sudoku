class SudokuLauncher
{
    /*
    create 9 by 9 board
    check game conditions
        row must be 1-9
        column must be 1-9
        boxes (%3) must be 1-9
        no repeating numbers
        no negative or numbers>9
    get winner
    */

    public static void main(String args[])
    {
        int[][] board = new int[SudokuHandler.BOARD_SIZE][SudokuHandler.BOARD_SIZE];
        for (int i = 0; i < SudokuHandler.BOARD_SIZE; i++) {
            for (int j = 0; j < SudokuHandler.BOARD_SIZE; j++) {
                board[i][j] = 0;
            }
        }
        GameState sh = new SudokuHandler(board);
        GameDriver sudoku = new GameDriver(sh);
        sudoku.play();
    }
}
