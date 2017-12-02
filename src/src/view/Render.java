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
        doTest(g);
        //renderMap(g, map.getMap());
        //renderPlayer(g, player.getPos());
    }

    @Deprecated
    public void renderText(String text) {
        //Renders text in a textbox
    }

    @Deprecated
    public void doTest(Graphics g) {
        g.setFont(new Font("Arial", 1, 24));
        g.setColor(new Color(255, 255, 255));
        g.drawString("hack_the_bubble", 20, 20);
    }

    public void renderMap(Graphics g, Block[][] blocks) {

    }

    public void renderPlayer(Graphics g, Dimension playerPos) {

    }

}
