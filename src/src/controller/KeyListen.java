package controller;

import model.IMap;
import model.IPlayer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

/**
 * Updates the player class on key press which will update the render
 */
public class KeyListen implements KeyListener {

    private IPlayer player;
    private IMap map;

    public KeyListen(IPlayer player, IMap map) {
        this.player = player;
        this.map = map;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) { }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(!player.hasLost() && !player.hasWon() && !player.isInteract()) {
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

        if(player.hasWon()) {
            int mapID = player.getMapID();
            player.setMapID(mapID++);

            if(mapID < 4) {
                map.readMapFromFile("Map" + mapID + ".txt");
                player.moveTo(1, 22);
            }
        }

        if(player.isInteract()) {
            switch (keyEvent.getKeyCode()) {
                case VK_ENTER:
                    player.setInteract(false);
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) { }
}
