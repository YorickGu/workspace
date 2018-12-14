package com.pfuser.service;

import com.pfuser.pojo.User;

public interface LoginService {
    //校验用户登录信息
    User checkLoginService(String uname, String pwd);
    //校验用户cookie信息
    User checkLoginService(String uid);
}
