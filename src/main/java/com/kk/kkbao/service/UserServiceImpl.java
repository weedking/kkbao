package com.kk.kkbao.service;

import com.kk.kkbao.dao.SUserMapper;
import com.kk.kkbao.pojo.SUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private SUserMapper sUserMapper;

    public SUser getUserById(int userId){
        return sUserMapper.selectByPrimaryKey(userId);
    }

    public boolean addUser(SUser record) {
        boolean result = false;
        try {
            sUserMapper.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean updateUser(SUser sUser){
        boolean result = false;
        try {
            sUserMapper.updateByPrimaryKeySelective(sUser);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteUser(int id){
        boolean result = false;
//        int id = 0;
        try {
            sUserMapper.deleteByPrimaryKey(id);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }
}
