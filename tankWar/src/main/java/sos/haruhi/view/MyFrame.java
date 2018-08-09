package sos.haruhi.view;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.*;

public class MyFrame extends JFrame {
    MyPanel panel = new MyPanel();
    public static final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(20, 40, 3600, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());

    public MyFrame() throws HeadlessException {
        this.add(panel);
        this.setLocation(400, 200);
        this.setSize(800, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this.panel);
        new Thread(this.panel).start();
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
