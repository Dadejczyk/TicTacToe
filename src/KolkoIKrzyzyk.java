import java.util.Scanner;

public class KolkoIKrzyzyk {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};

        printBoard(board);

        boolean endGame = false;


        while (!endGame) {
            Board.playerTurn(scanner, board);
            if (Board.draw(board)) {
                System.out.println("Draw");
                break;
            } else {
                System.out.println("Game on");
            }
            endGame = Board.endGame(board, 'X');
            if (endGame) {
                System.out.println("Player X win");
                break;
            }

            Board.secondPlayerTurn(scanner, board);
            if (Board.draw(board)){
                System.out.println("DRAW");
                break;
            }else {
                System.out.println("Game on");
            }
            endGame = Board.endGame(board, 'O');
            if (endGame) {
                System.out.println("Player O win");
                break;
            }
        }
    }
    static void printBoard(char[][] board) {
        System.out.println("Welcome in Tic_Tac_Toe GAME\n");
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("--+---+---");
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("--+---+---");
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }
}
