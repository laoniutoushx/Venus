package sos.haruhi.view;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyPanel panel = new MyPanel();

    public MyFrame() throws HeadlessException {
        this.add(panel);
        this.setLocation(400, 200);
        this.setSize(800, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this.panel);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
