package sos.haruhi.bean;

import java.awt.*;

public class Egg {
    public Coordinate coord = null;

    public Egg(int row, int col) {
        this.coord = new Coordinate(col, row);
    }

    public Node drawEgg(Graphics g){
        Node node = new Node(coord.getRow(), coord.getCol(), null);
        node.draw(g);
        return node;
    }

    @Override
    public String toString() {
        return "位置 x:" + coord.getCol() + ", y:" + coord.getRow();
    }
}
