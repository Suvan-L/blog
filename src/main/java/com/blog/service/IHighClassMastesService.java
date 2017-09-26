package com.blog.service;

import com.blog.entity.HighClassMastes;

import java.util.List;

/**
 * @Author Suvan
 * @Date 2017-06-24
 */
public interface IHighClassMastesService {

    public void insertHighClassMastes(HighClassMastes classMasterUser);       //插入数据


    public void deleteHighClassMastes(int highClassMastesId);                 //删除用户


    public HighClassMastes selectHighClassMastes(String highClassMastesName);  //查询用户
    List<HighClassMastes> selectAllMessage();                                 //查询所有用户的信息

}
