package controller;

import model.IPlayer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

/**
 * Updates the player class on key press which will update the render
 */
public class KeyListen implements KeyListener {

    private IPlayer player;

    public KeyListen(IPlayer player) {
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) { }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(!player.hasLost()) {
            switch (keyEvent.getKeyCode()) {
                case VK_LEFT:
                    player.move('l');
                    break;
                case VK_RIGHT:
                    player.move('r');
                    break;
                case VK_UP:
                    player.move('u');
                    break;
                case VK_DOWN:
                    player.move('d');
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) { }
}
