package com.blog.myunits.match;

/**
 * 正则匹配
 *
 * @Author Suvan
 * @Date 2017-06-03-22:13
 */
public class RegularMatch {
    /*
     * 正则匹配手机号
     *      中国移动 134,135,136,137,138,139,147,150,151,152,157,158,159,170,178,182,183,184,187,188    【chinamobile】
     *      中国联通 130,131,132,145,155,156,170,171,175,176,185,186     【chinaunicom】
     *      中国电信 133,149,153,170,173,177,180,181,189                 【chinatelecom】
     *      中国网通3G 188,189                                           【chinanetcom】
     *
     */
    public static  void matchPhone(String phone){
        String CMCC = "^((13[4-9])|(147)|(15[0-2,7-9])|(17[8])|(18[2-4,7-8]))[0-9]{8}|(170[5])\\d{7}$";
        String CUCC = "^((13[0-2])|(145)|(15[5-6])|(17[156])|(18[5,6]))\\d{8}|(170[4,7-9])\\d{7}$";  // \d是指[0-9]
        String CTCC = "^((133)|(149)|(153)|(17[3,7])|(18[0,1,9]))\\d{8}|(170[0-2])\\d{7}$";
        String CNCC = "[1]{1}[8]{1}[89]{1}[0-9]{8}$";


        if(phone.length() == 11){  //手机号长度11位

            //判断号码符合哪个规则
            if(phone.matches(CMCC)){
                System.out.println("中国移动");
            }
            else if(phone.matches(CUCC)){
                System.out.println("中国联通");
            }
            else if(phone.matches(CNCC)){
                System.out.println("中国网通");
            }
            else if(phone.matches(CTCC)){
                System.out.println("中国电信");
            }
            else {
                System.out.println("没有匹配！");
            }


        }else{
            System.out.println("长度不符合要求,注意是11位");
        }
    }

    public static void main(String[] args) {
        RegularMatch.matchPhone("18999999999");
    }
}
