import java.util.Scanner;

public class GameDriver
{
    private GameState state;

    public GameDriver(GameState initial)
    {
        state = initial;
    }
    public void play()
    {
        Scanner sc = new Scanner(System.in);
        state.genBoard();
        while (!state.isGameOver()) {
            System.out.println(state);
            System.out.print("Choose x-coor: ");
            int col = sc.nextInt() - 1;
            System.out.print("\nChoose y-coor: ");
            int row = sc.nextInt() - 1;
            System.out.print("\nChoose val: ");
            int val = sc.nextInt();
            if (state.conditionsMet(row, col, val)) {
                state.setBoard(row, col, val);
            }
        }
        System.out.println(state);
    }
}
