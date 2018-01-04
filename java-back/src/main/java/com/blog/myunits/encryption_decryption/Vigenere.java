package com.blog.myunits.encryption_decryption;

/**
 * Vigenere密码【维吉尼亚密码算法】
 *
 *      缺点：
 *          1.只加密小写字母a ~ z
 *          2.如果明文中有大写字母,加密后,再解密,全会变成小写
 *          3.密钥仅限小写字母
 *
 * @Author Suvan
 * @Date 2017-06-03-20:39
 */
public class Vigenere {

    private String plainText;           //明文
    private String key;                 //密钥
    private String cipherText;          //密文

    private char [][] vigSquare;        //Vigenere方阵

    /*无参构造器*/
    public Vigenere(){
        //循环赋值26行,26列,行首字母由A-Z,然后字母表顺序...
        vigSquare = new char[26][26];
        int pointer = 65;       //指针    【 unicode编码： A-65 Z-90 a-97 z-122 】
        int rowTop = 65;        //行的第一个字母
        for(int i = 1; i <= 26; i++){           //26行
            for(int j = 1; j <= 26; j++){       //26列
                if(pointer == 91){
                    pointer = 65;
                }
                vigSquare[i-1][j-1]= (char)pointer++; //指针赋值,自增
            }
            pointer = ++rowTop; //行首字母A ~ Z
            //System.out.println(Arrays.toString(vigSquare[i-1]));
        }
    }

    /*密钥合法性检查*/
    public int legality(String key){

        char tmpC;
        for(int i = 0, len = key.length(); i < len; i++){
            tmpC = key.charAt(i);
            if(tmpC < 'a' || 'z' < tmpC){       //出现非小写字符即不合法
                return 0;
            }
        }

        return 1;  //合法
    }

    /*加密【明文 + 密钥 = 密文】*/
    public String encrypt(String plainText,String key){ //参数：明文,密钥

        //1.明文,密钥全转为小写[Vigenere方阵是大写字母的，如果转成大写,解密的时候不好忽略明文中大写字母]
        plainText = plainText.toLowerCase();
        key = key.toLowerCase();

        //2.定义
        StringBuilder cipherText = new StringBuilder();      //储存密文
        int row,col;                                         //行(明文字母),列(密钥字母)
        int keyPointer = 0,keyLen = key.length();            //密钥指针,密钥长度
        char tmpC;                                           //临时字符
        int numI;                                            //储存汉字临时编号

        //3.加密
        for(int i = 0,len = plainText.length(); i < len; i++){
            //a
            tmpC = plainText.charAt(i);

            //b-小写字母 + 汉字
            if('a' <= tmpC && tmpC <= 'z') {
                row = (int) tmpC - 97;
                col = (int) key.charAt(keyPointer) - 97;
                cipherText.append(vigSquare[row][col]);  //加密字符
                keyPointer++;                            //密钥指针移动
            }
            else if(19968 <= (int)tmpC && (int)tmpC <= 40869){
                numI = (int)tmpC - 19968;  //获得汉字编号
                numI = (numI + (int)key.charAt(keyPointer)) % 20902;  //根据密钥字母进行移位
                cipherText.append((char)(numI + 19968));
                keyPointer++;
            }
            else{
                cipherText.append(tmpC);                 //不加密的数据直接返回
            }

            //c
            if (keyPointer == keyLen) {                  //密钥指针移动到最后时,返回0坐标
                keyPointer = 0;
            }
        }

        return cipherText.toString();
    }

    /*解密【密文 + 密钥 = 明文】*/
    public String decrypt(String cipherText,String key){

        //将密钥转成小写
        key = key.toLowerCase();

        //定义
        StringBuilder plainText = new StringBuilder();       //储存明文
        int row,col;                                         //行列
        int keyPointer = 0,keyLen = key.length();            //密钥指针,长度
        char tmpC;                                           //储存临时字符
        int numI;                                            //储存汉字临时编号

        //解密
        for(int i = 0,len = cipherText.length(); i < len; i++){
            //a
            tmpC = cipherText.charAt(i);                     //密文

            //b-大写字母+汉字
            if('A' <= tmpC && tmpC <= 'Z'){
                col = (int)key.charAt(keyPointer) - 97;      //列数[密钥]
                for(row = 0;; row++){                        //根据列数找到行数
                    if(vigSquare[row][col] == tmpC){
                        break;
                    }
                }
                keyPointer++;
                plainText.append((char)(row + 97));          //行的收字母即是明文的大写
            }
            else if(19968 <= (int)tmpC && (int)tmpC <= 40869){
                numI = (int)tmpC - 19968;                    //获得汉字编号
                numI = (numI + 20902 - (int)key.charAt(keyPointer)) % 20902;  //根据密钥字母得到对应的汉字编号
                plainText.append((char)(numI+19968));
                keyPointer++;
            }
            else{
                plainText.append(tmpC);
            }

            //c
            if(keyPointer == keyLen){
                keyPointer = 0;
            }
        }

        return plainText.toString();
    }

    /*主函数测试*/
    public static void main(String[] args) {
        Vigenere vigenere = new Vigenere();
        String result = vigenere.encrypt("data security你好啊","best");
        System.out.println(result);
        result = vigenere.decrypt("EELT TIUNSMLR係姢喽","best");
        System.out.println(result);

    }


}
