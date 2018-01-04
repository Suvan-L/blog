package com.blog.dao;

import com.blog.entity.HighClassMastes;

import java.util.List;


/**
 * highclassmastes
 *
 * @Author Suvan
 * @Date 2017-06-24 :32
 */
public interface IHighClassMastesDao {

    //插入
    int insert(HighClassMastes classMastesUser);

    //删除
    int deleteByPrimaryKey(Integer HighClassMastesId);

    //查询
    HighClassMastes selectByPrimaryKey(String HighClassMastesName);
    List<HighClassMastes> selectAllMessage();




}
