package view;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Frame implements Observer {

    private JFrame frame;
    private JPanel panel;
    private Dimension size = new Dimension(400, 400);

    private Graphics g;
    private Render render;

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
        g = panel.getGraphics();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
    }

    @Override
    public void update(Observable observable, Object o) {
        render.render();
    }
}
