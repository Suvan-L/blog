package com.blog.myunits.thread;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时执行【Timer定时器】
 *
 * @Author Suvan
 * @Date 2017-06-04-21:41
 */
public class TimmingDoTask {

    public static void main(String[] args) {
        //定时器
        Timer timer = new Timer();

        //任务
        TimerTask task_1 = new Task("NO.1");
        TimerTask task_2 = new Task("NO.2");
        TimerTask task_3 = new Task("NO.3");

        //100毫秒后执行
        timer.schedule(task_1,100);
        //200毫秒后执行,每1000毫秒再执行一次
        timer.schedule(task_2,200,1000);
        //指定时间执行
        Date date = new Date(System.currentTimeMillis() + 1000);
        timer.schedule(task_3,date);



        try{
            //等待5秒
            Thread.sleep(5000);  //上述是开启另外线程执行，主线程依旧执行,所以5秒后所有线程关闭
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        //终止定时器并却笑定时器中的任务
        timer.cancel();
    }
}
//定时任务
class Task extends TimerTask{
    private String ID;
    public Task(String ID){
        this.ID = ID;
    }
    public void run(){
        long time = System.currentTimeMillis();
        System.out.println("任务ID:" + ID + "---目前执行时间：" + time);
    }
}
