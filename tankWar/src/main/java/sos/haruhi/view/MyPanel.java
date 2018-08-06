package sos.haruhi.view;

import sos.haruhi.bean.Direction;
import sos.haruhi.bean.PlayerTank;
import sos.haruhi.bean.Type;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel implements KeyListener {

    PlayerTank myTank = null;

    public MyPanel() {
        myTank = new PlayerTank(10, 10);    // 初始化坦克
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(0, 0, 800, 500); // 背景填充
        this.drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirect(), Type.PLAYER);
    }

    public void drawTank(int x, int y, Graphics g, Direction direct, Type type){
        switch (type){
            case ENEMY:
                g.setColor(Color.CYAN);
                break;
            case PLAYER:
                g.setColor(Color.YELLOW);
                break;
        }
            System.out.println(x + " -- " + y);
        switch (direct){
            case U:
                //向上
                g.fill3DRect(x   , y    , 5 , 30, false);
                g.fill3DRect(x+15, y    , 5 , 30, false);
                g.fill3DRect(x+5 , y+5  , 10, 20, false);
                g.fillOval(x+4, y+10, 10 , 10);
                g.drawLine(x+9, y+15, x+9, y );
                break;
            case D:
                //向上
                g.fill3DRect(x   , y    , 5 , 30, false);
                g.fill3DRect(x+15, y    , 5 , 30, false);
                g.fill3DRect(x+5 , y+5  , 10, 20, false);
                g.fillOval(x+4, y+10, 10 , 10);
                g.drawLine(x+9, y+15, x+9, y+30 );
                break;
            case L:
                //向上
                g.fill3DRect(x   , y    , 5 , 30, false);
                g.fill3DRect(x+15, y    , 5 , 30, false);
                g.fill3DRect(x+5 , y+5  , 10, 20, false);
                g.fillOval(x+4, y+10, 10 , 10);
                g.drawLine(x+9, y+15, x+9, y );
                break;
            case R:
                //向上
                g.fill3DRect(x   , y    , 5 , 30, false);
                g.fill3DRect(x+15, y    , 5 , 30, false);
                g.fill3DRect(x+5 , y+5  , 10, 20, false);
                g.fillOval(x+4, y+10, 10 , 10);
                g.drawLine(x+9, y+15, x+9, y );
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                myTank.setDirect(Direction.U);
                myTank.move();
                break;
            case KeyEvent.VK_S:
                myTank.setDirect(Direction.D);
                myTank.move();
                break;
            case KeyEvent.VK_A:
                myTank.setDirect(Direction.L);
                myTank.move();
                break;
            case KeyEvent.VK_D:
                myTank.setDirect(Direction.R);
                myTank.move();
                break;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
