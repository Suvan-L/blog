package com.blog.myunits.print;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 打印图形
 *
 * @Author Suvan
 * @Date 2017-06-02-20:06
 */
public class PrintGraphics {

    /*判断闰年*/
    public static boolean isLoopYear(int year){
        //4年一闰[世纪年(位数2个0),必然被400整除才算]
        if((year%4 == 0) && (year%100 != 0) || (year%400 == 0)){
            return true;
        }

        return false;
    }
    /*判断是否为素数[打印指定范围内所有素数]*/
    public static void isPrimeNumber(int begin, int end){ //范围(开始-结束)
        int count = 0;  //计数

        SIGN:
            for(int i = begin; i <= end; i++){
                for(int j = 2; j <= Math.sqrt(i);j ++){
                    if(i % j == 0){
                        continue SIGN;  //将N整数从2开始,除到√N,没有一个数能整除，即为素数【有一个数能整除即跳到下一个数】
                    }
                }
                System.out.print(i + " ");
                if(++count % 10 == 0){
                    System.out.println();//换行
                }
            }

    }

    /*打印爱心*/
    private static void printLove(){
        String [] star = {"0100010",
                          "1010101",
                          "1001001",
                          "1000001",
                          "1000001",
                          "0100010",
                          "0010100",
                          "0001000",
                            };

        for(int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                char c = star[i].charAt(j);
                switch (c) {
                    case '0':System.out.print("\t");break;
                    case '1':System.out.print("*\t");
                }
            }
            System.out.println();
        }
    }

    /*99乘法表*/
    private static void printMultiplication99(){
        for(int i = 1; i <= 9; i++){
            for(int j = 1;j <= 9;j++){
                int result = i * j;         //结果
                String space;               //空格
                if(result >= 10)  space = " ";  //10位数2个空格
                else space = "  ";//个位数1个空格

                System.out.print(i + "*" + j + "=" + result + space);
            }
            System.out.println();//换行
        }
    }

    /*键盘输入流*/
    public static void printIO(int way) throws  IOException{ //参数：方式
        if(way == 1){
            int i = 0;
            while(i != -1){
                i = System.in.read(); //获取输入流,从输入流中读取数据的下一个字节
                System.out.print((char)i);  //i是字符的ASCII码值,强转为字符输出
            }
        }
        else if(way == 2){
            byte [] b = new byte[1024];     //数据缓冲
            int n = System.in.read(b);
            String s = new String(b,0,n); //将byte数组转为字符串
            System.out.println(s);
        }
        else if(way == 3){
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
        }
        else if(way == 4){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(br.readLine());
        }
    }


    public static void main(String[] args) throws IOException{
        printLove();
    }
}
