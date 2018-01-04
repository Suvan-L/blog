package com.blog.myunits.thread;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 测试线程
 *
 * @Author Suvan
 * @Date 2017-06-04-20:37
 */
public class BallMove {
    public static void main(String[] args) {
        Movement movement = new Movement();
        movement.setBounds(10,10,450,450);
        movement.setVisible(true);
        movement.setTitle("模拟自由裸体的平抛运动");

        movement.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
}
class Movement extends Frame implements Runnable{
    Thread redBall,blueBall;
    Ball red,blue;
    double t = 0;

    public Movement(){
        redBall = new Thread(this);
        blueBall = new Thread(this);

        red = new Ball(Color.red);
        blue = new Ball(Color.blue);

        this.setLayout(null);
        this.add(red);
        this.add(blue);

        red.setLocation(50,100);
        blue.setLocation(80,100);

        redBall.start();
        blueBall.start();
    }
    public void run(){
        while(true){
            t += 0.2;
            if(t > 20){
                t = 0;
            }
            if(Thread.currentThread() == redBall){
                int x = 50;
                int y = (int)(1.0/2*t*t*3.8) + 50;
                red.setLocation(x,y);
                try{
                    Thread.sleep(45);
                }catch(InterruptedException e){}
            }
            else if(Thread.currentThread() == blueBall){
                int x = 50;
                int y = (int)(1.0/2*t*t*3.8) + 50;
                blue.setLocation(x,y);
                try{
                    Thread.sleep(45);
                }catch (InterruptedException e){}

            }
        }
    }
}
class Ball extends Canvas{
    Color color;
    public Ball(Color color){
        this.setSize(20,02);
        this.color = color;
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(0,0,20,20);
    }
}
