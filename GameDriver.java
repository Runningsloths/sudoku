public class GameDriver
{
    private GameState state;

    public GameDriver(GameState initial)
    {
        state = initial;
    }
    public void play()
    {
        while (!state.isGameOver()) {
            System.out.print(state);
            if (state.conditionsMet()) {
                
            }
        }
    }
}
