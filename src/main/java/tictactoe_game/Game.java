package tictactoe_game;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmed
 */
public class Game {

    private Board board = new Board();

    private char currentPlayer = 'X';
    private boolean gameOver = false;

    private int row = -1, col = -1;
    private boolean moveReady = false;

    public Game() {
        board.resetBoard();
    }

    public synchronized void setMove(int r, int c) {
        row = r;
        col = c;
        moveReady = true;
        notifyAll();
    }

    public synchronized void playTurn(char player, GUI gui) {
        try {
            while (!gameOver) {

                while ((player != currentPlayer || !moveReady) && !gameOver) {
                    wait();
                }

                if (gameOver)
                    return;

                char[][] b = board.getBoard();

                if (b[row][col] == '-') {

                    board.placeMove(row, col, player);

                    gui.updateButton(row, col, player);

                    if (checkWinner()) {
                        gui.setStatus("Player " + player + " Wins!");
                        gameOver = true;

                    } else if (isDraw()) {
                        gui.setStatus("Draw!");
                        gameOver = true;

                    } else {
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                        gui.setStatus("Player " + currentPlayer + " Turn");
                    }
                }

                moveReady = false;
                notifyAll();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetBoard() {
        board.resetBoard();
        currentPlayer = 'X';
        gameOver = false;
    }

    public void startGame(GUI gui) {
        PlayerThread p1 = new PlayerThread(this, 'X', gui);
        PlayerThread p2 = new PlayerThread(this, 'O', gui);

        p1.start();
        p2.start();
    }

    public boolean checkWinner() {

        char[][] b = board.getBoard();

        for (int i = 0; i < 3; i++)
            if (b[i][0] == b[i][1] &&
                b[i][1] == b[i][2] &&
                b[i][0] != '-')
                return true;

        for (int i = 0; i < 3; i++)
            if (b[0][i] == b[1][i] &&
                b[1][i] == b[2][i] &&
                b[0][i] != '-')
                return true;

        if (b[0][0] == b[1][1] &&
            b[1][1] == b[2][2] &&
            b[0][0] != '-')
            return true;

        if (b[0][2] == b[1][1] &&
            b[1][1] == b[2][0] &&
            b[0][2] != '-')
            return true;

        return false;
    }

    public boolean isDraw() {

        char[][] b = board.getBoard();

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (b[i][j] == '-')
                    return false;

        return true;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
