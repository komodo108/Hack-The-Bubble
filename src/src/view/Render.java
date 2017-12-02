package view;

import java.awt.*;

public class Render {

    private Dimension size;
    private Graphics g;

    public Render(Graphics g, Dimension size) {
        this.g = g;
        this.size = size;
    }

    public void renderText(String text) {
        g.drawRect(size.height);
    }



}
