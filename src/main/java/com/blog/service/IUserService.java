package com.blog.service;

import com.blog.entity.User;

/**
 *  【业务逻辑层】UserService接口
 *
 *
 * @Author Suvan
 * @Date 2017-05-19-9:39
 */
public interface IUserService{

    public String insertUser(User user);

    public String deleteUserById(Integer id);


    public User selectUserById(Integer id);
    public User selectUserByName(String name);
    public String selectByNameOnlyUser(String name);

    public String updateUser(User user);    //更新用户(根据id)
}
