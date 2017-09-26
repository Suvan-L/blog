package com.blog.myunits;

/**
 *  个人工具包：
 *      生成随机数
 *
 * @Author Suvan
 * @Date 2017-05-30-9:59
 */
public class CreateRandomNumber {

    /*获取6位数随机数*/
    public static String getSixRandomNumber(){
        //1.定义
        Integer number = null;

        //2.生成随机数
        //long seed = System.currentTimeMillis(); //取当前毫秒数作为随机数种子【只是随机算法的起源数字,和生成随机数的区间没有关系】
        //number = new Random(seed).nextInt();  //(可在来括号内指定范围0~范围)

        number = (int)((Math.random() * 9 +1) * 100000) ;//生成6位数随机数【Math.random()产生的类型的double,范围是产生的随机数应该是0.0000...-1.00000...之间】

        return String.valueOf(number);
    }


    /*测试主函数*/
    //public static void main(String[] args) {
    //    for(int i = 0; i <= 1000;i++){
    //        System.out.println(CreateRandomNumber.getSixRandomNumber());
    //    }
    //
    //}
}
