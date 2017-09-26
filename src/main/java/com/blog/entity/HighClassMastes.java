package com.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 高中同学会记录
 *
 * @Author Liu-shuwei
 * @Date 17.7.9
 */

public class HighClassMastes {
    private Integer id;             //用户id

    private String name;            //姓名
    private String phone;           //手机号
    private String city;            //居住城市
    private String area;            //详细地址(单位或家庭)
    private String postCode;        //邮编
    private String join;            //参加同学(是/否)
    private String traffic;         //交通出行情况(自驾/大巴)
    private String money;           //赞助金额


    @JsonFormat(pattern="yyyy-MM-dd- HH:mm",timezone = "GMT+8")
    private Date publictime;        //提交时间


    //Setter
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setJoin(String join) {
        this.join = join;
    }
    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public void setPublictime(Date publictime) {
        this.publictime = publictime;
    }

    public void setMoney(String money) {
        this.money = money;
    }



    //Getter
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public String getArea() {
        return area;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getJoin() {
        return join;
    }
    public String getTraffic() {
        return traffic;
    }

    public Date getPublictime() {
        return publictime;
    }

    public String getMoney() {
        return money;
    }


    @Override
    public String toString() {

        String sdfPublicTime =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(publictime);

        return "****************************************\n" +
                "姓名名: " + name + '\n' +
                "手机号: " + phone + '\n' +
                "目前居住城市: " + city + '\n' +
                "通讯地址(单位或家庭)【选填】: " + area + '\n' +
                "邮编: " + postCode + '\n' +
                "参加同学(是/否): " + join + '\n' +
                "交通出行情况(自驾/大巴): " + traffic + '\n' +
                "赞助金额(元)：" +  money + '\n' +
                "提交时间: " + sdfPublicTime  + '\n' +
                "****************************************";
    }
}
