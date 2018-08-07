package sos.haruhi.bean;

import java.awt.*;

public class EnemyTank extends Tank {
    public EnemyTank(int x, int y) {
        super(x, y);
        this.setType(Type.ENEMY);
        this.setColor(Color.CYAN);
    }
}
