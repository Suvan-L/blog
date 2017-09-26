package com.blog.myunits.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 获取文件信息
 *
 * @Author Suvan
 * @Date 2017-06-05-8:25
 */
public class TreatFile {

    /*获取文件信息*/
    public void GetFileInformation(String pathFileName){
        //3.获取文件信息
        File file = new File(pathFileName);

        if(file.exists()){      //判断文件是否存在
            if(file.isFile()){
                System.out.println(file.getName() + "是一个文件  ---> ");
                System.out.println("是否是绝对路径：" + file.isAbsolute());
                System.out.println("是否可读:" + file.canRead());
                System.out.println("是否可写:" + file.canWrite());
                System.out.println("是否隐藏:" + file.isHidden());
                System.out.println("该文件大小:" + file.length());
                System.out.println("最后修改时间：" + file.lastModified());
            }
            else if(file.isDirectory()){
                System.out.println(file.getName() + "是一个目录  ---> ");
                File [] fileList = file.listFiles();       //获取本目录下的子文件 and 子目录
                int fileCount = 0;                         //文件数s
                int directoryCount = 0;                    //目录数
                String list_filename = null;               //列表里文件名
                StringBuilder space = new StringBuilder(); //储存空格

                //执行遍历
                for(int i = 0,len = fileList.length; i < len; i++){
                   list_filename = fileList[i].getName();

                   //自动补齐空格,提高观赏性
                   space.setLength(0);
                   for(int k=0; k<20 - list_filename.length(); k++){
                       space.append(" ");
                   }

                    if(fileList[i].isFile()){
                        fileCount++;
                        System.out.println( list_filename + space + "【子文件】");
                    }else{
                        directoryCount++;
                        System.out.println( list_filename + space + "【子目录】") ;
                    }
                }
                System.out.println(file.getName() + "目录拥有" + fileCount + "个子文件和" +directoryCount + "个子目录");
            }
        }else{
            System.out.println(file.getName() + "该文件不存在");
        }
    }

    /*创建目录*/
    public void createDirectory(String pathDirectoryName){
        File directory = new File(pathDirectoryName);
        if(directory.exists()){
            System.out.println(directory + " -> 目录已经存在,创建失败");
        }else{
            if(directory.mkdir()){
                System.out.println("创建目录成功！");
            }else{
                System.out.println("创建目录失败");
            }
        }
    }
    /*创建文件*/
    public void createFile(String pathFileName){
        File file = new File(pathFileName);

        if(file.exists()){
            System.out.println(pathFileName + " -> 文件已经存在,创建失败");
        }else{
            try{
                if(file.createNewFile()){
                    System.out.println("创建文件成功！");
                }else{
                    System.out.println("创建文件失败！");
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    /*删除目录[or 文件]*/
    public void deleteFile(String pathFileName){
        File file = new File(pathFileName);

        if(file.exists()){
            if(file.delete()){
                System.out.println("删除成功！");
            }else{
                System.out.println("删除失败！");
            }
        }else{
            System.out.println(pathFileName + " -> 不存在目录 or 文件,删除失败!");
        }
    }
    /*重命名目录[or 文件]*/
    public void renameFile(String pathFileName,String newfileName){
        File file = new File(pathFileName);
        if(file.exists()){

            String path = pathFileName.substring(0,pathFileName.lastIndexOf("/"));
            File newfile = new File(path + "/" + newfileName);
            if(file.renameTo(newfile)){
                System.out.println("重命名成功!");
            }else{
                System.out.println("重命名失败！");  //文集新文件名已经存在的话,则重名也会失败
            }

        }else{
            System.out.println(pathFileName + "文件不存在,无法重命名！");
        }
    }
    /*使用Runtime运行文件*/
    public void runFile(String pathFileName){
        try{
            Runtime runntime = Runtime.getRuntime();// 返回与当前 Java 应用程序相关的运行时对象。[注意：应用程序不能创建自己的Runtime实例]
            File file = new File(pathFileName);
            String suffix = pathFileName.substring(pathFileName.lastIndexOf(".")).toLowerCase(); //文件后缀(转为小写)


            //判断运行
            if(file.exists()){
                if(".exe".equals(suffix) ||  ".cmd".equals(suffix)){
                    Process process = runntime.exec(file.getAbsolutePath()); //获取本机进程
                    process.waitFor();  //waitFor()-导致当前线程等待，如有必要，一直要等到由该 Process 对象表示的进程已经终止。
                    System.out.println("运行成功!");
                }else{
                    System.out.println(pathFileName + ",不是可执行文件");
                }

            }else{
                System.out.println(pathFileName + ",文件不存在");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /*获取用户输入*/
    public String getConsoleInput(){
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(in);
        String consoleInput = null;
        try{
            consoleInput = buffer.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }

        return consoleInput;
    }

    /*测试主函数*/
    public static void main(String [] args){
        //定义
        TreatFile treatFile = new TreatFile();   //处理文件



        ////获取文件信息
        //System.out.println("请输入文件名[相对路径 or 绝对路径]:");
        //String fileNName = treatFile.getConsoleInput();
        //treatFile.GetFileInformation("e:/hexo");
        //
        ////创建目录 and 文件
        //treatFile.createDirectory("C:/Users/Liu-shuwei/Desktop/你好");
        //treatFile.createFile("C:/Users/Liu-shuwei/Desktop/小胶皮.pp");
        //
        ////删除
        //treatFile.deleteFile("C:/Users/Liu-shuwei/Desktop/小胶皮.pp");
        //
        ////重命名
        //treatFile.renameFile("C:/Users/Liu-shuwei/Desktop/你好","哈哈");

        //运行文件
        treatFile.runFile("C:/windows/system32/calc.exe");  //执行计算机
    }
}
