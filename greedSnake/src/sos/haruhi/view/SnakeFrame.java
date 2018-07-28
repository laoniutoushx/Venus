package sos.haruhi.view;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SnakeFrame extends Frame {
    // 方格大小
    private static final int BLOCK_WIDTH = 20;
    private static final int BLOCK_HEIGHT = 20;
    // 行数列数
    private static final int ROWS = 40;
    private static final int COLS = 40;

    public void lunch(){
        this.setTitle("greedySnake");
        this.setSize(BLOCK_WIDTH * ROWS, BLOCK_HEIGHT * COLS);
        this.setLocation(300, 200);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SnakeFrame().lunch();
    }
}
