package sos.haruhi.view;

import sos.haruhi.bean.Direction;
import sos.haruhi.bean.MyTank;
import sos.haruhi.bean.Type;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel {

    MyTank myTank = null;

    public MyPanel() {
        myTank = new MyTank(10, 10);    // 初始化坦克
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(0, 0, 800, 500); // 背景填充
        this.drawTank(myTank.getX(), myTank.getY(), g, Direction.U, Type.PLAYER);
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
        switch (direct){
            case U:
                //向上
                g.fill3DRect(x   , y    , 5 , 30, false);
                g.fill3DRect(x+15, y    , 5 , 30, false);
                g.fill3DRect(x+5 , y+5  , 10, 20, false);
                g.fillOval(x+4, y+10, 10 , 10);
                g.drawLine(x+9, y+15, x+9, y );
                break;
        }
    }
}
