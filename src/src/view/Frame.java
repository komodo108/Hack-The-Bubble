package view;

import controller.KeyListen;
import model.IMap;
import model.IPlayer;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Frame extends Observable {

    private JFrame frame;
    private JPanel panel;
    private Dimension size = new Dimension(400, 400);

    private Graphics g;
    private Render render;

    private IPlayer player;
    private IMap map;

    public Frame() {
        makeFrame();
        render = new Render(g);
    }

    public void makeFrame() {
        frame = new JFrame("Hack the Bubble");
        frame.setLayout(null);
        frame.setSize(size);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0));
        panel.addKeyListener(new KeyListen(player));
        g = panel.getGraphics();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
    }
}
