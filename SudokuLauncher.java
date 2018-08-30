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
        GameState sh = new SudokuHandler();
        GameDriver sudoku = new GameDriver(sh);
        sudoku.play();
    }
}
