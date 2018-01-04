package com.blog.myunits.thread;

import java.io.*;

/**
 * 利用管道进行线程通信
 *
 * @Author Suvan
 * @Date 2017-06-04-20:53
 */
public class PipedCommunication {
    public static void main(String[] args) {
        //创建管道
        PipedInputStream pipIn = new PipedInputStream();  //输入管道
        PipedOutputStream pipOut = new PipedOutputStream(); //输出管道

        try{
            pipIn.connect(pipOut);  //连接管道

            MsgOut out = new MsgOut(pipOut);
            MsgIn in = new MsgIn(pipIn);

            //开启线程
            out.start();
            in.start();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
class MsgOut extends Thread{
    DataOutputStream dataOut;
    String content;
    public MsgOut(PipedOutputStream pipOut){
        dataOut = new DataOutputStream(pipOut);

    }
    public void run(){
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(in);
        //标准输入流读取数据
        System.out.println("请输入内容:");
        try{
            content = buffer.readLine();        //获取控制台输入
        }catch (IOException e){
            e.printStackTrace();
        }

        //向管道中吸入数据
        System.out.println("MsgOut发送到管道的信息 ->  " + content);
        try{
            dataOut.writeUTF(content);
            dataOut.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
class MsgIn extends Thread{
    DataInputStream dataIn;
    public MsgIn(PipedInputStream pipIn){
        dataIn = new DataInputStream(pipIn);
    }
    public void run(){
        //从管道读取数据
        String content;
        try{
            content = dataIn.readUTF();
            System.out.println("MsgIn接收来自于管道的信息 ->" + content);
            dataIn.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
