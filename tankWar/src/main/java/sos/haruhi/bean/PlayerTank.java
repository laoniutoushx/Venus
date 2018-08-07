package sos.haruhi.bean;

import java.awt.*;
import java.util.Vector;

public class PlayerTank extends Tank {
    private Vector<Bullet> bullets = new Vector<>();
    public PlayerTank(int x, int y) {
        super(x, y);
        this.setType(Type.PLAYER);
        this.setColor(Color.YELLOW);
    }

    public void shotting(){

    }
}
