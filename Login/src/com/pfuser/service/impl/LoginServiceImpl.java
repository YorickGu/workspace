package com.pfuser.service.impl;

import com.pfuser.dao.LoginDao;
import com.pfuser.dao.impl.LoginDaoImpl;
import com.pfuser.pojo.User;
import com.pfuser.service.LoginService;

/**
 * Description: 创建Dao层过渡对象
 *
 * @param:
 * @return:
 * @auther: Yorick
 * @date: 2018/12/2 19:53
 */
public class LoginServiceImpl implements LoginService {
    //数据现在是从浏览器到servlet，从servlet流到service ，从service流转到DAO，从DAO开始操作数据库，
    // 从库里去看有无这个信息，有的话把这个信息流转到service，从service流转到servlet，
    // servlet再看这个结果怎么给浏览器的响应

    LoginDao ld = new LoginDaoImpl();

    @Override
/**
 * Description: 该方法是用来检验有无已有的登陆信息
 * @param: [uname, pwd]
 * @return: com.pfuser.pojo.User
 * @auther: Yorick
 * @date: 2018/12/2 20:02
 */
    public User checkLoginService(String uname, String pwd) {

        return ld.ckeckLoginDao(uname, pwd);
    }

    @Override
    public User checkLoginService(String uid) {
        return ld.checkUidDao(uid);
    }

}
