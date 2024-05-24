import java.util.Arrays;

public class GameBoard {

    private char[][] board;
    private final int size = 3;

    public GameBoard() {
        this.board = new char[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(board[i], ' ');
        }
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
            if (i < size - 1) {
                System.out.println("---------");
            }
        }
    }

    public boolean isValidMove(int row, int column) {
        return row >= 0 && row < size && column >= 0 && column < size && board[row][column] == ' ';
    }


    public void makeMove(int row, int column, Player player) {
        board[row][column] = player.getSymbol();
    }

    public boolean isDraw() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }

    public boolean isWin() {
        for (int i = 0; i < size; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }

        for (int j = 0; j < size; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }

        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }

        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }

    public void resetBoard(){
        for(int i = 0; i < size; i++){
                Arrays.fill(board[i], ' ');
        }
    }



}