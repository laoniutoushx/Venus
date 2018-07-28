package sos.haruhi.bean;

import sos.haruhi.view.SnakeFrame;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Snake {
    public Node head = null;
    public Node tail = null;

    private SnakeFrame snakeFrame;

    // 初始化蛇的位置
    private Node node = new Node(3, 4, Direction.D);
    private int size = 0;   //

    public Snake(SnakeFrame snakeFrame) {
        this.head = node;
        this.tail = node;
        this.snakeFrame = snakeFrame;
        size++;
    }

    public Node addNodeInHead(Direction dir){
        int _row = head.row;
        int _col = head.col;
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
        return _node;
    }

    public void removeNodeInTail(){
        tail = tail.pre;
        tail.next = null;
    }

    public void move(){
        addNodeInHead(null);
        removeNodeInTail();
    }

    public void earease(Graphics g){
        tail.earease(g);
    }

    public void draw(Graphics g){
        if(head == null){
            return;
        }
        earease(g);
        move();
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
