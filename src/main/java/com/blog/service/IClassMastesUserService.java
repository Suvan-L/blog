package com.blog.service;

import com.blog.entity.ClassMastesUser;

import java.util.List;

/**
 * @Author Suvan
 * @Date 2017-06-24
 */
public interface IClassMastesUserService {

    public void insertClassMastesUser(ClassMastesUser classMasterUser);       //插入数据


    public void deleteClassMastesUser(int classMastesUserId);                 //删除用户


    public ClassMastesUser selectClassMastesUser(String classMastesUserName);  //查询用户
    List<ClassMastesUser> selectAllMessage();                                 //查询所有用户的信息

}
