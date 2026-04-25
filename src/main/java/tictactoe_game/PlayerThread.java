package tictactoe_game;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmed
 */
public class PlayerThread extends Thread {
    Game game;
    char player;
    GUI gui;

    public PlayerThread(Game game, char player, GUI gui) {
        this.game = game;
        this.player = player;
        this.gui = gui;
    }

    public void run() {
        game.playTurn(player, gui);
    }
}
