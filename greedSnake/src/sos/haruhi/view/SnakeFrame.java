package sos.haruhi.view;

import sos.haruhi.bean.Direction;
import sos.haruhi.bean.Egg;
import sos.haruhi.bean.Snake;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SnakeFrame extends Frame {

    // 方格大小
    public static final int BLOCK_WIDTH = 30;
    public static final int BLOCK_HEIGHT = 30;
    // 行数列数
    public static final int ROWS = 30;
    public static final int COLS = 30;

    public static SnakeFrame snakeFrame = null;
    private static Snake snake = null;
    public static Graphics graphics = null;     // 图形渲染
    public static Egg egg = null;
    public Thread thread = null;

    @Override
    public void paint(Graphics g) {

        Color c = g.getColor();
        g.setColor(Color.GRAY);
        /*
         * 将界面画成由ROW*COL的方格构成,两个for循环即可解决
         * */
        for (int i = 0; i < ROWS; i++) {
            g.drawLine(0, i * BLOCK_HEIGHT, COLS * BLOCK_WIDTH, i * BLOCK_HEIGHT);
        }
        for (int i = 0; i < COLS; i++) {
            g.drawLine(i * BLOCK_WIDTH, 0, i * BLOCK_WIDTH, ROWS * BLOCK_HEIGHT);
        }
        g.setColor(c);

    }

    private Image offScreenImage = null;

    /*
     * 重写update方法
     * 利用双缓冲来解决闪烁的问题
     * */
    @Override
    public void update(Graphics g) {

        if (offScreenImage == null) {
            offScreenImage = this.createImage(ROWS * BLOCK_HEIGHT, COLS * BLOCK_WIDTH);
        }
        Graphics offg = offScreenImage.getGraphics();
        //先将内容画在虚拟画布上
        paint(offg);
        snake.draw(offg);
        egg.drawEgg(offg);
        //然后将虚拟画布上的内容一起画在画布上
        g.drawImage(offScreenImage, 0, 0, null);


    }

    private class MyPaintThread implements Runnable {

        @Override
        public void run() {
            //每隔50ms重画一次
            while (true) {
                repaint();//会自动调用paint方法
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public void lunch() {
        this.setTitle("greedySnake");
        this.setSize(BLOCK_WIDTH * ROWS, BLOCK_HEIGHT * COLS);
        this.setLocation(300, 30);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                snake.keyPressed(e);
            }
        });
        this.setResizable(false);
        this.setVisible(true);
        lunchFrame();   // 开启渲染
        graphics = super.getGraphics(); // 获取渲染器
        /**
         * 创建 蛋
         */
        egg = new Egg(15, 15);
        egg.drawEgg(graphics);
    }

    public void lunchFrame() {
        thread = new Thread(new MyPaintThread());
        thread.start();    // 开启画面渲染线程
    }

    public void stopFrame(){
        thread.interrupt();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        snakeFrame = new SnakeFrame();
        snake = new Snake(snakeFrame);
        snakeFrame.lunch();
    }
}
