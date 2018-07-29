package sos.haruhi.bean;

import sos.haruhi.view.SnakeFrame;

import java.awt.*;

public class Node {
    private static final int BLOCK_WIDTH = SnakeFrame.BLOCK_WIDTH;
    private static final int BLOCK_HEIGHT = SnakeFrame.BLOCK_HEIGHT;
    /*
     * 每个节点的位置
     * */
    public Coordinate coord;
    //方向
    public Direction dir;

    public Node pre;
    public Node next;

    public Node(int row, int col, Direction dir) {
        this.coord = new Coordinate(col, row);
        this.dir = dir;
    }

    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.BLACK);
        g.fillRect(coord.getCol() * BLOCK_WIDTH, coord.getRow() * BLOCK_HEIGHT, BLOCK_WIDTH, BLOCK_HEIGHT);
        g.setColor(c);
    }

    public void earease(Graphics g){
        g.clearRect(coord.getCol() * BLOCK_WIDTH, coord.getRow() * BLOCK_HEIGHT, BLOCK_WIDTH, BLOCK_HEIGHT);
    }
}
