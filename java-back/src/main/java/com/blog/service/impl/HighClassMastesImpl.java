package com.blog.service.impl;

import com.blog.dao.IHighClassMastesDao;
import com.blog.entity.HighClassMastes;
import com.blog.service.IHighClassMastesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Liu-shuwei
 * @Date 17.7.9
 */
@Service("highClassMastesService")
public class HighClassMastesImpl implements IHighClassMastesService {
    @Resource
    protected IHighClassMastesDao highClassMastesDao;


    public void insertHighClassMastes(HighClassMastes highClassMastes){
        highClassMastesDao.insert(highClassMastes);
    }


    public void deleteHighClassMastes(int highclassMastesId){
        highClassMastesDao.deleteByPrimaryKey(highclassMastesId);
    }


    public HighClassMastes selectHighClassMastes(String highClassMastesId){
        return highClassMastesDao.selectByPrimaryKey(highClassMastesId);
    }

    public List<HighClassMastes> selectAllMessage(){
        return  highClassMastesDao.selectAllMessage();
    }
}
