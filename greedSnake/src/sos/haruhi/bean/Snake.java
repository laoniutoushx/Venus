package sos.haruhi.bean;

import sos.haruhi.view.SnakeFrame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

public class Snake {
    public Node head = null;
    public Node tail = null;

    private Set<Coordinate> snakePosition = new HashSet<Coordinate>();

    private SnakeFrame snakeFrame;
    private Random random = new Random();

    // 初始化蛇的位置
    private Node node = new Node(3, 4, Direction.D);
    private int size = 0;   //

    public Snake(SnakeFrame snakeFrame) {
        snakePosition.add(node.coord);    // 添加位置
        this.head = this.tail = node;
        this.snakeFrame = snakeFrame;
        size++;
    }

    public Node addNodeInHead(Direction dir){
        int _row = head.coord.getRow();
        int _col = head.coord.getCol();
        if(dir == null){
            dir = head.dir;
        }
        switch (dir){
            case D:{
                _row++;
                break;
            }
            case U:{
                _row--;
                break;
            }
            case L:{
                _col--;
                break;
            }
            case R:{
                _col++;
                break;
            }
        }
        Node _node = new Node(_row, _col, dir);
        head.pre = _node;
        _node.next = head;
        head = _node;
        if(!snakePosition.add(_node.coord)){    // 添加位置
            SnakeFrame.snakeFrame.stopFrame();  // 当有重复数据添加时说明头部遇到了身体，终止线程
        }
        return _node;
    }

    public void removeNodeInTail(){
        snakePosition.remove(tail.coord);     // 删除位置
        tail = tail.pre;
        tail.next = null;
    }

    public boolean collisionCheck(){
        // 墙壁碰撞检测
        if(head.coord.getRow() >= 30 || head.coord.getCol() >= 30
            || head.coord.getRow() < 0 || head.coord.getCol() < 0){
            SnakeFrame.snakeFrame.stopFrame();
        }
        // 身体碰撞检测

        // 食物碰撞检测
        boolean flag = head.coord.equals(SnakeFrame.egg.coord);
        if(flag){
            System.out.println("吃到蛋：" + SnakeFrame.egg.toString());
        }
        return flag;
    }

    public void updateEggPosition(Graphics g){
        int x = random.nextInt(SnakeFrame.COLS);
        int y = random.nextInt(SnakeFrame.ROWS);
        Coordinate tempCoord = new Coordinate(x, y);
        while(snakePosition.contains(tempCoord)){
            x = random.nextInt(SnakeFrame.COLS);
            y = random.nextInt(SnakeFrame.ROWS);
            tempCoord = new Coordinate(x, y);
        }
        Egg egg = SnakeFrame.egg;
        egg.coord = tempCoord;
        egg.drawEgg(g);
    }

    public void move(Graphics g){
        addNodeInHead(null);
        if(!collisionCheck()){      // 未碰撞
            removeNodeInTail();     // 删除末节点
        }else{                      // 以碰撞
            updateEggPosition(g);    // 刷新食物位置
        }
    }

    public void earease(Graphics g){
        tail.earease(g);
    }

    public void draw(Graphics g){
        if(head == null){
            return;

        }
        earease(g);
        move(g);
        for(Node node = head; node != null; node = node.next){
            node.draw(g);
        }
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case 37:{
                if(head.dir != Direction.R){
                    head.dir = Direction.L;
                }
                break;
            }
            case 38:{
                if(head.dir != Direction.D){
                    head.dir = Direction.U;
                }
                break;
            }
            case 39:{
                if(head.dir != Direction.L){
                    head.dir = Direction.R;
                }
                break;
            }
            case 40:{
                if(head.dir != Direction.U){
                    head.dir = Direction.D;
                }
                break;
            }
        }
    }
}
