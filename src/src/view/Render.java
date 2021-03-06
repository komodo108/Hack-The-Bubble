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

    private String text;

    private SpriteLoader loader;

    public Render(Dimension size, IMap map, IPlayer player) {
        this.size = size;
        this.map = map;
        this.player = player;
        this.text = "";

        try {
            loader = new SpriteLoader(32, 32, 8, 8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderMap(g, map.getMap());
        renderPlayer(g, map.getMap());
        renderJumps(g);
        renderText(g);

        if(player.hasWon()) renderWin(g);
        else if(player.hasLost()) renderLoss(g);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void renderText(Graphics g) {
        //Renders text in a textbox
        if(!text.equals("")) {
            g.setColor(new Color(255, 255, 255));
            g.fillRect(20, 20, size.width - 40, 60);
            g.setColor(new Color(0, 0, 0));
            g.fillRect(25, 25, size.width-50, 50);
            g.setColor(new Color(255, 255, 255));
            g.setFont(new Font("Courier", 1, 20));
            g.drawString(text, 30, 57);
        }
    }

    public void renderMap(Graphics g, Block[][] blocks) {
        for(int x = 0; x < blocks.length; x++) {
            for(int y = 0; y < blocks[x].length; y++) {
                switch (blocks[x][y].type) {
                    case Block.empty:
                        g.drawImage(loader.getSprites(10), x * 32, y * 32, null);
                        break;
                    case Block.door:
                        g.drawImage(loader.getSprites(5), x * 32, y * 32, null);
                        break;
                    case Block.finish:
                        g.drawImage(loader.getSprites(13), x * 32, y * 32, null);
                        break;
                    case Block.blockage1:
                        g.drawImage(loader.getSprites(7), x * 32, y * 32, null);
                        break;
                    case Block.blockage2:
                        g.drawImage(loader.getSprites(7), x * 32, y * 32, null);
                        break;
                    case Block.ERROR:
                        System.err.println("There was an error with rendering the blocks!");
                        g.drawImage(loader.getSprites(9), x * 32, y * 32, null);
                        break;
                    case Block.floor:
                        g.drawImage(loader.getSprites(2), x * 32, y * 32, null);
                        break;
                    case Block.key:
                        g.drawImage(loader.getSprites(6), x * 32, y * 32, null);
                        break;
                    case Block.lava:
                        g.drawImage(loader.getSprites(3), x * 32, y * 32, null);
                        break;
                    case Block.lever1:
                        g.drawImage(loader.getSprites(4), x * 32, y * 32, null);
                        break;
                    case Block.lever2:
                        g.drawImage(loader.getSprites(4), x * 32, y * 32, null);
                        break;
                    case Block.spike:
                        g.drawImage(loader.getSprites(1), x * 32, y * 32, null);
                        break;
                    case Block.upgrade:
                        g.drawImage(loader.getSprites(8), x * 32, y * 32, null);
                        break;
                    case Block.wall:
                        g.drawImage(loader.getSprites(2), x * 32, y * 32, null);
                        break;
                    case Block.cute1:
                        g.drawImage(loader.getSprites(19), x * 32, y * 32, null);
                        break;
                    case Block.cute2:
                        g.drawImage(loader.getSprites(20), x * 32, y * 32, null);
                        break;
                    case Block.enemy:
                        g.drawImage(loader.getSprites(22), x * 32, y * 32, null);
                        break;

                }
            }
        }
    }

    public void renderPlayer(Graphics g, Block[][] blocks) {
        for(int x = 0; x < blocks.length; x++) {
            for (int y = 0; y < blocks[x].length; y++) {
                if(player.getPos().width == x && player.getPos().height == y) {
                    g.drawImage(loader.getSprites(0), x * 32, y * 32, null);
                }
            }
        }
    }

    public void renderJumps(Graphics g) {
        g.setFont(new Font("Courier", 1, 36));
        g.setColor(new Color(255, 255, 0));
        g.drawString(String.valueOf(player.getJumps()), 10, 40);
    }

    public void renderWin(Graphics g) {
        String s = "You Win!";

        g.setColor(new Color(255, 215, 0, 80));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier", 1, 24));
        g.drawString(s, size.width / 2 - ((s.length() * 24) / 4), size.height / 2 - 12);
    }

    public void renderLoss(Graphics g) {
        String s = "You Lose!";

        g.setColor(new Color(255, 0, 0, 160));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier", 1, 24));
        g.drawString(s, size.width / 2 - ((s.length() * 24) / 4), size.height / 2 - 12);
    }

}
