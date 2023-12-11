import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    void testValidMove() {
        char[][] board = {{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};
        assertTrue(Board.isValidMove(board,1,1));

    }
    @Test
    void testInvalidMoveIsAlreadyTaken() {
        char[][] board = {{'X', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};
        assertFalse(Board.isValidMove(board,0,0));
    }
    @Test
    void testEndGameForFirstPlayer() {
        char[][] board = {{'X', ' ', 'O'},{'X', 'O', ' '},{'X', ' ', 'O'}};
        assertTrue(Board.endGame(board,'X'));
    }
    @Test
    void testEndGameForSecondPlayer() {
        char[][] board = {{'O', ' ', 'X'},{'O', 'X', ' '},{'O', ' ', 'X'}};
        assertTrue(Board.endGame(board,'O'));
    }

    @Test
    void testDraw() {
        char[][] board = {{'X', 'O', 'X'}, {'O', 'X', 'O'}, {'O', 'X', 'O'}};
        assertTrue(Board.draw(board));
    }
}