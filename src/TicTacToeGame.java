public class TicTacToeGame {

    private GameBoard gameBoard;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public TicTacToeGame(){
        gameBoard = new GameBoard();
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
    }


    public void startGame(){
        GameController gameController = new GameController(this);
        gameController.play();
    }

    public void switchPlayer(){
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
