package com.blog.dao;

import com.blog.entity.ClassMastesUser;

import java.util.List;


/**
 * 操作ClassMasterUser表
 *
 * @Author Suvan
 * @Date 2017-06-24 :32
 */
public interface IClassMastesUserDao {

    //插入
    int insert(ClassMastesUser classMastesUser);

    //删除
    int deleteByPrimaryKey(Integer classMasterUserId);

    //查询
    ClassMastesUser selectByPrimaryKey(String classMasterUserName);
    List<ClassMastesUser> selectAllMessage();




}
