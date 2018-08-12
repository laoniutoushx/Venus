package sos.haruhi.bean;

import sos.haruhi.view.MyFrame;

public class Bullet implements Runnable {
    private int x;
    private int y;
    private Direction direct;
    private int speed = 5;
    private boolean isLive = true;
    private Tank tank;

    public Bullet(int x, int y, Direction direct, Tank tank) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        MyFrame.threadPool.execute(this);
        this.tank = tank;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirect() {
        return direct;
    }

    public void setDirect(Direction direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    @Override
    public void run() {
        while(this.isLive){
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                // TODO: handle exception
            }
            switch(this.direct){
                case U:
                    y+=speed;
                    break;
                case D:
                    y-=speed;
                    break;
                case L:
                    x-=speed;
                    break;
                case R:
                    x+=speed;
                    break;
                default:
                    break;
            }

//          System.out.println(""+x+" "+y);
            //子弹何时死亡
            if(x<0||x>800||y<0||y>500){
                this.isLive = false;
                tank.bullets.remove(this);
            }
        }
}
}
