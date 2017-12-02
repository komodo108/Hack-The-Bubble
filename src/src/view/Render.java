package view;

import model.IMap;
import model.IPlayer;
import shared.Block;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Render extends JPanel {

    private Dimension size;
    private IMap map;
    private IPlayer player;

    private SpriteLoader loader;

    public Render(Dimension size, IMap map, IPlayer player) {
        this.size = size;
        this.map = map;
        this.player = player;

        try {
            loader = new SpriteLoader(16, 16, 8, 8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderMap(g, map.getMap());
        renderPlayer(g, map.getMap());
    }

    @Deprecated
    public void renderText(String text) {
        //Renders text in a textbox
    }

    public void renderMap(Graphics g, Block[][] blocks) {
        for(int x = 0; x < blocks.length; x++) {
            for(int y = 0; y < blocks[x].length; y++) {
                switch (blocks[x][y].type) {
                    case Block.empty:
                        g.drawImage(loader.getSprites(10), x * 16, y * 16, null);
                        break;
                    case Block.door:
                        g.drawImage(loader.getSprites(5), x * 16, y * 16, null);
                        break;
                    case Block.finish:
                        g.drawImage(loader.getSprites(10), x * 16, y * 16, null);
                        break;
                    case Block.blockage1:
                        g.drawImage(loader.getSprites(7), x * 16, y * 16, null);
                        break;
                    case Block.blockage2:
                        g.drawImage(loader.getSprites(7), x * 16, y * 16, null);
                        break;
                    case Block.ERROR:
                        System.err.println("There was an error with rendering the blocks!");
                        g.drawImage(loader.getSprites(9), x * 16, y * 16, null);
                        break;
                    case Block.floor:
                        g.drawImage(loader.getSprites(2), x * 16, y * 16, null);
                        break;
                    case Block.key:
                        g.drawImage(loader.getSprites(6), x * 16, y * 16, null);
                        break;
                    case Block.lava:
                        g.drawImage(loader.getSprites(3), x * 16, y * 16, null);
                        break;
                    case Block.lever1:
                        g.drawImage(loader.getSprites(4), x * 16, y * 16, null);
                        break;
                    case Block.lever2:
                        g.drawImage(loader.getSprites(4), x * 16, y * 16, null);
                        break;
                    case Block.spike:
                        g.drawImage(loader.getSprites(1), x * 16, y * 16, null);
                        break;
                    case Block.upgrade:
                        g.drawImage(loader.getSprites(8), x * 16, y * 16, null);
                        break;
                    case Block.wall:
                        g.drawImage(loader.getSprites(2), x * 16, y * 16, null);
                        break;

                }
            }
        }
    }

    public void renderPlayer(Graphics g, Block[][] blocks) {
        for(int x = 0; x < blocks.length; x++) {
            for (int y = 0; y < blocks[x].length; y++) {
                if(player.getPos().height == x && player.getPos().width == y) {
                    g.drawImage(loader.getSprites(0), x * 16, y * 16, null);
                }
            }
        }
    }

    public void renderJumps(Graphics g) {
        g.setFont(new Font("Courier New", 1, 8));
        g.setColor(new Color(205, 205, 0));
        g.drawString(player.get);
    }

}
