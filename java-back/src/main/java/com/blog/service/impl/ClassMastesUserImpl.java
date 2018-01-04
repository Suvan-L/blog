package com.blog.service.impl;

import com.blog.dao.IClassMastesUserDao;
import com.blog.entity.ClassMastesUser;
import com.blog.service.IClassMastesUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Liu-shuwei
 * @Date 17.6.24
 */
@Service("classMastesUserService")
public class ClassMastesUserImpl implements IClassMastesUserService{
    @Resource
    protected IClassMastesUserDao classMastesUserDao;


    public void insertClassMastesUser(ClassMastesUser classMasterUser){
        classMastesUserDao.insert(classMasterUser);
    }


    public void deleteClassMastesUser(int classMastesUserId){
        classMastesUserDao.deleteByPrimaryKey(classMastesUserId);
    }


    public ClassMastesUser selectClassMastesUser(String classMastesUserId){
        return classMastesUserDao.selectByPrimaryKey(classMastesUserId);
    }
    public List<ClassMastesUser> selectAllMessage(){
        return  classMastesUserDao.selectAllMessage();
    }
}
