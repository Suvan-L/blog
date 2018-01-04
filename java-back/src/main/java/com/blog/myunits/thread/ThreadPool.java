package com.blog.myunits.thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * 简单的线程池
 *
 * @Author Suvan
 * @Date 2017-06-04-22:24
 */
//测试线程池
class  test{
    public static void main(String[] args) throws Exception{
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(in);
        String str;
        int threadCount;
        int numTasks;

        System.out.println("请输入线程池中的线程数:");
        str = buffer.readLine();
        threadCount = Integer.parseInt(str);
        ThreadPool threadPool = new ThreadPool(threadCount);


        System.out.println("请输入任务数：");
        str = buffer.readLine();
        numTasks = Integer.parseInt(str);

        //运行任务
        for(int i = 0; i<numTasks; i++){
            threadPool.performTask(new MyThreadTask(i));
        }

        //关闭线程等待所有任务完成
        threadPool.join();
    }
}
//线程池主类
public class ThreadPool extends ThreadGroup{
    private boolean isAlive;                        //标记线程池是否开启
    private LinkedList<ThreadTask> threadQueue;     //线程池中的任务队列
    private int threadId;                           //线程池中的线程id
    private static int threadPoolId;                //线程id

    /*构造方法[创建新的线程池]*/
    public ThreadPool(int threadCount){  //参数：线程数
        super("ThreadPool-" + (threadPoolId++));
        super.setDaemon(true);      //表示当线程池中所有线程被销毁时,该线程池也自动被销毁

        this.isAlive = true;
        this.threadQueue = new LinkedList<ThreadTask>();

        //启动threadCount个工作线程
        for(int i = 0; i < threadCount; i++){
            new PooledThread().start();
        }
    }

    /*添加新任务[添加完任务就唤醒线程执行任务]*/
    public synchronized void performTask(ThreadTask task){//参数：任务
        if(!this.isAlive){
            throw new IllegalStateException(); //如果线程被关闭,抛出异常
        }
        if(task != null){
            this.threadQueue.add(task);  //将任务放到任务队列尾部
            notify();                    //通知工作线程获取任务[notify()-唤醒在此对象监视器上等待的单个线程]
        }
    }

    /*获取任务*/
    protected synchronized ThreadTask getTask(){
        //如果任务列表为空,而且线程池没被关闭,则当前线程进入等待扎un柜台
        while(this.threadQueue.size() == 0){
            if(!this.isAlive){
                return null;
            }


            try{
                wait();  // wait()-在其他线程调用此对象的 notify() 方法或 notifyAll() 方法前，导致当前线程等待。
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        return  (ThreadTask)this.threadQueue.removeFirst(); //[removeFirst()-移除并返回此列表的第一个元素。]
    }

    /*强制关闭线程池[停止所有线程，不再执行任务]*/
    public synchronized void close(){
        if(isAlive){
            this.isAlive = false;
            this.threadQueue.clear();   //[clear()-,停止所有线程，不再执行任务】
            this.interrupt();           //ThreadGroup.interrupt()-中断此线程组中的所有线程
        }
    }

    /*有条件的关闭线程池*/
    public void join(){

        //通知其他等待线程,该线程池已关闭
        synchronized (this){
            isAlive = false;
            notifyAll();   // notifyAll()-唤醒在此对象监视器上等待的所有线程。
        }

        //等待所有线程池完成
        Thread [] threads = new Thread[this.activeCount()]; //建立一个新的线程数组[ThreadGroup.activeCount() -返回此线程组中活动线程的估计数。]

        //将线程池中的活动线程赋值到新创建的线程数组threads中
        int count = this.enumerate(threads);
        for(int i =0; i < count; i++){
            try{
                //等待线程运行结束
                threads[i].join();  //join()- 等待该线程终止
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }


    /*【内部类】用于执行任务的工作线程*/
    private class  PooledThread extends Thread{
        public PooledThread(){
            super(ThreadPool.this,"PooledTread-" + (threadId++));//线程所在的线程池对象,线程的名字
        }
        public void run(){
            //如果线程没有被中断
            while(!isInterrupted()){
                //1.获取任务
                ThreadTask task = null;
                task = getTask();

                //只要线程池的任务列表不为空,getTask()方法总能得到一个任务
                //若getTask()返回null,则标识线程池中已经没有任务,而且线程池已被关闭
                if(task == null){
                    return;
                }

                //2.执行任务
                try{
                    task.perform();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
    }
}
//任务接口类
interface ThreadTask{
    public void perform() throws Exception; //执行任务
}
class MyThreadTask implements ThreadTask{
    private int taskId = 0;  //任务ID

    public MyThreadTask(int taskId){
        this.taskId = taskId;
    }
    /*实现ThreadTask接口的perform方法*/
    public void perform() throws Exception{
        System.out.println("线程"+ taskId + " -> 开始");
        Thread.sleep(1000);
        System.out.println("线程"+ taskId + " -> 结束");
    }
}
