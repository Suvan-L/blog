package com.blog.myunits.thread;

/**
 * 哲学家就餐
 *      5个人在圆桌子,桌子中央一个饭,两人中级1筷子
 *          【哲学家必须先拿左边的筷子,再拿右边，有2个筷子才能吃饭】【筷子只有5只，不吭你所有人同时吃饭】
 *
 * @Author Suvan
 * @Date 2017-06-04-21:11
 */
public class ChostickDining {
    /*测试主方法*/
    public static void main(String[] args) {
        Chopsticks [] sticks = new Chopsticks[5];       //储存5个筷子
        Philosopher [] pher = new Philosopher[5];       //储存5个哲学家
        Thread [] threads = new Thread[5];              //储存5个线程

        //创建5个筷子
        for(int i = 0; i < 5; i++ ){
            sticks[i] = new Chopsticks(i + 1);  //筷子编号
        }
        //创建5个哲学家
        for(int i = 0; i < 5; i++){

            pher[i] = new Philosopher(sticks[i],sticks[(i+1) %5],i+1);//左右筷子,哲学家编号
        }
        //创建五个线程代表5个哲学家
        for(int i = 0; i < 5;i++){
            threads[i] = new Thread(pher[i]);
        }

        //启动五个线程
        for(int i = 0; i<5; i++){
            threads[i].start();
        }

    }
}
//筷子类
class Chopsticks{
    boolean using;          //可拿起状态
    int number;             //筷子编号
    public Chopsticks(int number){
        using = true;
        this.number = number;
    }
    public synchronized void takeup(int n){  //参数：哲学家编号
        while(using){
            System.out.println( n + "号哲学家拿起" + number + "号筷子");
            using = false;
        }
    }
    public  synchronized void putdown(int n){
        System.out.println(n + "好哲学家放下" + number + "号筷子");
        using = true;
    }
}
//哲学家类
class Philosopher implements Runnable{
    Chopsticks left,right;  //左右筷子
    int n;                  //哲学家编号
    boolean take;           //标识是否拿起两双筷子

    public Philosopher(Chopsticks left,Chopsticks right,int n){
        this.left = left;
        this.right = right;
        this.n = n;

        this.take = false; //表示没有拿起2根筷子
    }
    public  void run(){
        while(true){
            eat(); //吃饭
            try{
                Thread.sleep(0,10); //在指定的毫秒数加指定的纳秒数内让当前正在执行的线程休眠（暂停执行
            }catch (InterruptedException e){}

            think();//思考
            try{
                Thread.sleep(0,10);
            }catch (InterruptedException e){}
        }
    }
    /*吃饭*/
    public void eat(){
        if(left.using && right.using && !take){ //左右两个筷子都可被拿起,并且哲学家处于没拿2根筷子状态
            left.takeup(n);
            right.takeup(n);
            take = true;   //哲学家拿了2个框子
            System.out.println(n + "号哲学家拿起【"+left.number + ","+right.number+"号】,开始吃饭");
        }else{
            System.out.println(n + "号哲学家正在等待.........");
        }
    }
    /*思考*/
    public void think(){
        if((!left.using) && (!right.using) && take){  //左右两个筷子被拿起
            left.putdown(n);
            right.putdown(n);
            take = false;
            System.out.println(n + "号哲学家放下【"+left.number + ","+right.number+"号】筷子,开始思考...");
        }
    }
}