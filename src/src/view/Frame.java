package view;

import controller.KeyListen;
import model.IMap;
import model.IPlayer;
import model.Map;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Frame implements Observer {

    private JFrame frame;
    private Dimension size = new Dimension(800, 837);

    private Render render;
    private IPlayer player;
    private IMap map;

    public Frame() {
        this.map = new Map();
        map.readMapFromFile("Map4.txt");

        this.player = new Player(map);

        makeFrame();
        this.player.addAnObserver(this);
    }

    public void makeFrame() {
        frame = new JFrame("Hack the Bubble");
        frame.setLayout(null);
        frame.setSize(size);
        frame.setResizable(false);

        render = new Render(size, map, player);
        render.setBounds(0, 0, size.width, size.height);

        frame.addKeyListener(new KeyListen(player, map));
        frame.add(render);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.repaint();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                render.paintComponent(render.getGraphics());
                render.repaint();
            }
        });
    }

    @Override
    public void update(Observable observable, Object o) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                render.paintComponent(render.getGraphics());
                render.repaint();
            }
        });
    }
}
