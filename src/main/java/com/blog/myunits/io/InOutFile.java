package com.blog.myunits.io;

import java.io.*;

/**
 * InputStream,OutputStream的输入输出流
 *
 * @Author Suvan
 * @Date 2017-06-05-15:39
 */
public class InOutFile {

    /*字节流读取文件【会自动换行,中文会出现乱码,覆盖旧文件】*/
    public void readFile_InputStream(String pathFileName) {
        File file = new File(pathFileName);
        FileInputStream fileIn;
        byte[] buffer = new byte[100]; //字节缓冲区

        if (file.exists()){
            try {
                fileIn = new FileInputStream(file);

                //读取文件内容[ read(byte[] b, int off, int len) -从此输入流中将最多 len 个字节的数据读入一个 byte 数组中。]
                while ((fileIn.read(buffer, 0, 1)) != -1) {
                    System.out.print((char)buffer[0]);
                }


                fileIn.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("文件不存在");
        }
    }
    /*字节流写文件【win系统利用\r\n换行,覆盖旧文件】*/
    public void writeFile_OutputStream(String pathFileName,String content){
        File file = new File(pathFileName);
        FileOutputStream fileOut;
        byte [] buffer = content.getBytes();     //字节缓冲区

        if(file.exists()){
            try{
                fileOut = new FileOutputStream(file);

                fileOut.write(buffer);

                fileOut.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }else{
            System.out.println("文件不存在。");
        }
    }
    /*字节流复制文件【无法复制目录和不可读文件】*/
    public void copyFile_InOutStream(String pathFileName,String newpathFileName){
        File file = new File(pathFileName);
        File newfile = new File(newpathFileName);
        FileInputStream fileIn;
        FileOutputStream fileOut;
        byte [] buffer = new byte[1024];
        int len;  //字符长度

        try{
            fileIn = new FileInputStream(file);
            fileOut = new FileOutputStream(newfile);

            while((len = fileIn.read(buffer,0,1024)) != -1){
                fileOut.write(buffer,0,len);
            }

            fileOut.close();
            fileIn.close();

            System.out.println("文件复制成功！");
        }catch (IOException e){
            e.printStackTrace();
        }
    }



    /*字符流读取文件【可自动换行,中文不会乱码,覆盖旧文件】*/
    public void readFile_Reader(String pathFileName){
        File file = new File(pathFileName);
        FileReader fileRed;
        char [] buffer = new char[1024];  //字符缓冲区
        int len = 0;
        String str;

        try{
            fileRed = new FileReader(file);

            //读取
            while ((len = fileRed.read(buffer)) != -1){
                str = new String(buffer,0,len);
                System.out.print(str);
            }

            fileRed.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    /*字符输出流*/
    public void writeFile_Writer(String pathFileName,String content){
        File file = new File(pathFileName);
        FileWriter fileWri;
        char [] buffer = content.toCharArray();  //字符缓冲区

        try{
            fileWri = new FileWriter(file);


            ////使用'A'加密,解密的话再^ 'A'
            for(int i = 0; i < buffer.length; i ++){
                buffer[i] = (char)(buffer[i] ^ 'A');
                buffer[i] = (char)(buffer[i] ^ 'A');  //再^一次,即是解密
            }
            fileWri.write(buffer,0,buffer.length);

            fileWri.close();

        }catch (IOException e){
            e.printStackTrace();
        }


    }

    /*随机访问 and 插入数据内容[java.io.RandomAccessFile]*/
    public void readWriteFile(String pathFileName){
        File file = new File(pathFileName);
        RandomAccessFile rfile;
        byte [] buffer = new byte[256];
        int len;
        String str = "";                        //临时字符串

        try{
            rfile = new RandomAccessFile(file,"rw");//读写模式

            ////读
            //while((str = rfile.readLine()) != null){
            //    str=new String(str.getBytes("ISO-8859-1"),"GBK"); //转为汉字
            //    System.out.println(str);
            //}

            //写
            rfile.seek(rfile.length()); //设置文件指针指向文件结尾
            rfile.write("学习".getBytes("utf-8"));




            rfile.close();



        }catch (IOException e){
            e.printStackTrace();
        }


    }

    /*标准输出流*/
    public String printWriter(String pathFileName,String content){
        File file =  new File(pathFileName);
        PrintWriter writer;

        try{
            writer = new PrintWriter(new FileWriter(file));
            writer.println(content);   //写入内容

            writer.flush();
            writer.close();

        }catch (IOException e){
            e.printStackTrace();
            return "标准输出流写入失败！";
        }

        return "标准输出流写入成功！";
    }


    /*获取控制台输入*/
    public String getConsoleInput(){
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(in);
        String consoleInput = null;

        try{
            consoleInput = buffer.readLine();
        }catch (IOException kkk){}

        return consoleInput;
    }
    /*测试主函数*/
    public static void main(String [] args){
        InOutFile io = new InOutFile();

        //标准输出流
        //String result = io.printWriter("C:/Users/Liu-shuwei/Desktop/你好.txt","\r\n阿斯蒂芬23123"); //\r\n是windows换行符
        //System.out.println(result);

        ////字节流读取,写入,复制文件
        //io.readFile_InputStream("C:/Users/Liu-shuwei/Desktop/你好.txt");
        //io.writeFile_OutputStream("C:/Users/Liu-shuwei/Desktop/你好.txt","afasdf巴拉巴拉\r\n香蕉皮");
        //io.copyFile_InOutStream("C:/Users/Liu-shuwei/Desktop/你好.txt","C:/Users/Liu-shuwei/Desktop/我是皮皮.txt");

        ////字符流读取
        //io.readFile_Reader("C:/Users/Liu-shuwei/Desktop/你好.txt");
        //io.writeFile_Writer("C:/Users/Liu-shuwei/Desktop/刮破.txt","加密内容");

        //RandomAccessFile读取与写入
        io.readWriteFile("C:/Users/Liu-shuwei/Desktop/123.txt");
    }
}
