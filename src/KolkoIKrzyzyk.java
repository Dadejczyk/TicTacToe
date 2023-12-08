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
            playerTurn(scanner, board);

            if (draw(board)){
                System.out.println("Draw");
                break;
            }else {
                System.out.println("Game on");
            }

            endGame = endGame(board, 'X');
            if (endGame) {
                System.out.println("Player X win");
                break;
            }

            secondPlayerTurn(scanner, board);

            if (draw(board)){
                System.out.println("DRAW");
                break;
            }else {
                System.out.println("Game on");
            }

            endGame = endGame(board, 'O');
            if (endGame) {
                System.out.println("Player O win");
                break;
            }


        }
    }
    private static void playerTurn(Scanner scanner, char[][] board) {
        System.out.println("Player X");
        System.out.println(" Enter the number 1-9 that will place an X in the field of your choice\n");
        int userInput = scanner.nextInt();


        int position = Integer.parseInt(String.valueOf(userInput)) - 1;
        int rowNumber = position / 3;
        int columnNumber = position % 3;

        if (userInput < 1) {
            System.out.println("The number must not be less than 1");
            playerTurn(scanner, board);
            return;
        }else if (userInput > 9) {
            System.out.println("The number must not be greater than 9");
            playerTurn(scanner, board);
            return;
        }

        if (isValidMove(board, rowNumber, columnNumber)) {
            board[rowNumber][columnNumber] = 'X';
        } else {
            System.out.println("Invalid move. The selected field is already taken or out of range. Try again.");
            playerTurn(scanner, board);
            return;
        }

        switch (userInput) {
            case 1:
                board[0][0] = 'X';
                break;
            case 2:
                board[0][1] = 'X';
                break;
            case 3:
                board[0][2] = 'X';
                break;
            case 4:
                board[1][0] = 'X';
                break;
            case 5:
                board[1][1] = 'X';
                break;
            case 6:
                board[1][2] = 'X';
                break;
            case 7:
                board[2][0] = 'X';
                break;
            case 8:
                board[2][1] = 'X';
                break;
            case 9:
                board[2][2] = 'X';
                break;
            default:
        }
        printBoard(board);
    }
    private static void secondPlayerTurn(Scanner scanner, char[][] board) {
        System.out.println("Player O");
        System.out.println(" Enter the number 1-9 that will place an Y in the field of your choice\n");
        int userInput = scanner.nextInt();

        int position = Integer.parseInt(String.valueOf(userInput)) - 1;
        int rowNumber = position / 3;
        int columnNumber = position % 3;

        if (userInput < 1) {
            System.out.println("The number must not be less than 1");
            secondPlayerTurn(scanner, board);
            return;
        }else if (userInput > 9) {
            System.out.println("The number must not be greater than 9");
            secondPlayerTurn(scanner, board);
            return;
        }

        if (isValidMove(board, rowNumber, columnNumber)) {
            board[rowNumber][columnNumber] = 'O';
        } else {
            System.out.println("Invalid move. The selected field is already taken or out of range. Try again.");
            secondPlayerTurn(scanner, board);
            return;
        }


        switch (userInput) {
            case 1:
                board[0][0] = 'O';
                break;
            case 2:
                board[0][1] = 'O';
                break;
            case 3:
                board[0][2] = 'O';
                break;
            case 4:
                board[1][0] = 'O';
                break;
            case 5:
                board[1][1] = 'O';
                break;
            case 6:
                board[1][2] = 'O';
                break;
            case 7:
                board[2][0] = 'O';
                break;
            case 8:
                board[2][1] = 'O';
                break;
            case 9:
                board[2][2] = 'O';
                break;
            default:
        }
        printBoard(board);
    }

    private static boolean isValidMove(char[][] board, int rowNumber, int columnNumber) {
        return board[rowNumber][columnNumber] == ' ' && rowNumber >= 0 && rowNumber < 3 && columnNumber >= 0 && columnNumber < 3;
    }

    private static boolean endGame(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }
    private static boolean draw(char[][] board) {
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                return false;
        }
        return true;
    }


    private static void printBoard(char[][] board) {
        System.out.println("Welcome in Tic_Tac_Toe GAME\n");
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("--+---+---");
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("--+---+---");
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }
}
