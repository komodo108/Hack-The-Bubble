package view;

import model.IMap;
import model.IPlayer;
import shared.Block;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Render extends JPanel {

    private Dimension size;
    private IMap map;
    private IPlayer player;

    public Render(Dimension size, IMap map, IPlayer player) {
        this.size = size;
        this.map = map;
        this.player = player;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderMap(g, map.getMap());
        renderPlayer(g, player.getPos());
    }

    @Deprecated
    public void renderText(String text) {
        //Renders text in a textbox
    }

    public void renderMap(Graphics g, Block[][] blocks) {
        for(int i = 0; i < blocks.length; i++) {
            for(int j = 0; j < blocks[i].length; j++) {
                char block = blocks[i][j];
                switch (blocks[i][j]) {
                    case Block.empty:
                        break;
                    case Block.door:
                        break;
                    case Block.finish:
                        break;

                }
            }
        }
    }

    public void renderPlayer(Graphics g, Dimension playerPos) {

    }

}
