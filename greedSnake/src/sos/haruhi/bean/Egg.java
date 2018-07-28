package sos.haruhi.bean;

import sos.haruhi.view.SnakeFrame;

import java.awt.*;

public class Egg {
    private int row;
    private int col;

    private static int WIDTH = SnakeFrame.BLOCK_WIDTH;
    private static int HEIGHT = SnakeFrame.BLOCK_HEIGHT;

    public Egg(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Node drawEgg(Graphics g){
        Node node = new Node(this.row, this.col, null);
        node.draw(g);
        return node;
    }
}
