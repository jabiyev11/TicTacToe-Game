import java.util.Scanner;

public class GameController {

    private TicTacToeGame game;
    private Scanner scanner;


    public GameController(TicTacToeGame game){
        this.game = game;
        scanner = new Scanner(System.in);
    }

    public void play(){
        boolean playing = true;
        boolean playAgain = true;
        while(playAgain) {
            game.getGameBoard().resetBoard();
            playing = true;
            while (playing) {
                game.getGameBoard().printBoard();
                makePlayerMove(game.getCurrentPlayer());
                if (game.getGameBoard().isWin()) {
                    game.getGameBoard().printBoard();
                    System.out.println("Player " + game.getCurrentPlayer().getSymbol() + " wins!");
                    playing = false;
                } else if (game.getGameBoard().isDraw()) {
                    game.getGameBoard().printBoard();
                    System.out.println("Nobody won, Game finished as a Draw");
                    playing = false;
                }
                if(playing)
                    game.switchPlayer();
            }
            playAgain = askToPlayAgain();
        }
    }

    private void makePlayerMove(Player player) {
        boolean moveMade = false;
            while (!moveMade) {
                System.out.println("Player " + player.getSymbol() + ", enter your move(row and column)");
                int row = scanner.nextInt() - 1;
                int column = scanner.nextInt() - 1;
                if (game.getGameBoard().isValidMove(row, column)) {
                    game.getGameBoard().makeMove(row, column, player);
                    moveMade = true;
                } else {
                    System.out.println("Invalid move, try again");
                }
            }
        }

        private boolean askToPlayAgain(){
            System.out.println("Do you want to play again?(Yes/No)");
            String response = scanner.next().trim().toLowerCase();
            while(!response.equals("no") && !response.equals("yes")){
                System.out.println("Invalid Response. Please respond 'Yes' or 'No'");
                response = scanner.next().trim().toLowerCase();
            }
            return response.equals("yes");
        }

    }

