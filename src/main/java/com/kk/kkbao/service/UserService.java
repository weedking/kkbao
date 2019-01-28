package com.kk.kkbao.service;

import com.kk.kkbao.pojo.SUser;

public interface UserService {
    public SUser getUserById(int userId);
    boolean addUser(SUser user);
    boolean updateUser(SUser sUser);
//    boolean setPojo();
}
