package com.blog.myunits.io;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * 压缩,解压文件
 *
 * @Author Suvan
 * @Date 2017-06-05-16:44
 */
public class ZipUnZipFile {

    /*压缩文件【压缩单个文件成zip格式】*/
    public void zipFile(String pathFileName) throws Exception{
        //1.定义
        File file = new File(pathFileName);
        String suffix = pathFileName.substring(pathFileName.lastIndexOf("."));  //获取文件后缀
        String zipName = pathFileName.replaceFirst(suffix,".zip");              //压缩文件名
        File zipFile = new File(zipName);
        ZipEntry zipEntry = new ZipEntry(file.getName());           //压缩文件内条目对象
        byte [] buffer = new byte[1024];                            //缓冲区
        int len;
        FileInputStream fileIn = new FileInputStream(file);
        DataInputStream dataIn = new DataInputStream(fileIn);       //数据流
        FileOutputStream fileOut = new FileOutputStream(zipFile);
        ZipOutputStream zipOut = new ZipOutputStream(fileOut);
        DataOutputStream dataOut = new DataOutputStream(zipOut);



        //2.创建文件,进行压缩
        if(!zipFile.exists()){
            File zipDir = new File(zipFile.getParent());
            if(!zipDir.exists()){
                zipDir.mkdirs();
            }
            zipFile.createNewFile();
        }
        zipOut.setMethod(ZipOutputStream.DEFLATED);     //设置压缩方法
        zipOut.setComment("测试压缩文件");               //zip文件注释
        zipOut.putNextEntry(zipEntry);
        while((len = dataIn.read(buffer)) != -1){
            dataOut.write(buffer,0,len);
        }

        //3.关闭流
        dataOut.close();
        dataIn.close();

    }


    /*解压文件【解压zip文件,将里面所有文件解压到当前目录】*/
    public void unzipFile(String pathFileNameZip) throws Exception{//参数：压缩文件
        //1.定义
        ZipFile zipFile = new ZipFile(new File(pathFileNameZip));   //解压文件
        String unzipPath = pathFileNameZip.substring(0,pathFileNameZip.lastIndexOf("/"));   //解压路径
        System.out.println(unzipPath);

        File tmpfile = null;                                        //临时文件对象
        ZipEntry tmpZipEntry = null;
        byte [] buffer = new byte[1024];                            //缓冲区
        int len;
        InputStream in;
        DataInputStream dataIn;
        FileOutputStream fileOut;
        DataOutputStream dataOut;
        Enumeration enumeration = zipFile.entries();                          //压缩问价内的文件条目

        while(enumeration.hasMoreElements()){
            tmpZipEntry = (ZipEntry)enumeration.nextElement();
            tmpfile = new File(unzipPath + File.separator + tmpZipEntry); //压缩路径 + 路径分隔符 + 文件条目
            if(!tmpfile.exists()){
                tmpfile.createNewFile();//不存在则创建文件
            }

            in = zipFile.getInputStream(tmpZipEntry);
            dataIn = new DataInputStream(in);       //数据流
            fileOut = new FileOutputStream(tmpfile);
            dataOut = new DataOutputStream(fileOut);

            //解压
            while((len = dataIn.read(buffer,0,buffer.length)) != -1){
                dataOut.write(buffer,0,len);
            }

            //关闭流
            dataOut.close();
            fileOut.close();
            dataIn.close();
            in.close();

        }
    }


    /*测试主函数*/
    public static void main(String[] args) {
        ZipUnZipFile zip = new ZipUnZipFile();


        try{
            ////压缩文件
            //zip.zipFile("C:/Users/Liu-shuwei/Desktop/123.txt");
            //解压文件
            zip.unzipFile("C:/Users/Liu-shuwei/Desktop/Desktop.zip");
        }catch (Exception e){}

    }

}
