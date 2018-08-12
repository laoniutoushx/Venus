package sos.haruhi.bean;

import java.awt.*;

public class PlayerTank extends Tank {

    public PlayerTank(int x, int y) {
        super(x, y);
        this.setType(Type.PLAYER);
        this.setColor(Color.YELLOW);
    }

    public void shotting(){
        Bullet bullet = null;
        switch (this.getDirect()){
            case U:
                bullet = new Bullet(this.getX() -4,this.getY() + 8,this.getDirect(), this);
                break;
            case D:
                bullet = new Bullet(this.getX() - 4,this.getY() - 8,this.getDirect(), this);
                break;
            case L:
                bullet = new Bullet(this.getX() - 8,this.getY() - 4,this.getDirect(), this);
                break;
            case R:
                bullet = new Bullet(this.getX() + 8,this.getY() - 4,this.getDirect(), this);
                break;
        }
        super.bullets.add(bullet);
    }
}
