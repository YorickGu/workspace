package com.pfuser.dao;

import com.pfuser.pojo.User;

/**
 * @author guyao
 */

public interface LoginDao {

//    DAO层是直接和数据库进行操作的,service是用来封装具体的业务的
//    举个例子,dao层是封装了用户的增删该查操作,而业务上是要求能够实现批量删除用户的操作,
//     service就是封装出一个批量删除用户的功能,但是其实只是循环调用dao的单个删除操作而已
//    public void batchDel(List<User> ls){
//        for(int i=0;i<ls.size();i++){
//
//            dao.del((User)ls.get(i));
//
//        }
//    }
//    看了上面的例子应该明白了吧，Service封装具体的业务，dao只是封装基本的数据库元操作。
//    这样dao就可以做到尽可能的“轻”，而Service又避免了与具体数据库的关联。
//    当系统要迁移到其他数据库的时候，只需要实现一个相应的dao就可以了！


    /**
     * Description: 根绝用户名和密码获取用户信息
     * @param: [uname, pwd]
     * @return: com.pfuser.pojo.User
     */
    User ckeckLoginDao(String uname, String pwd);

    /**
     * Description: 根据uid获取用户信息
     * @param: [uid]
     * @return: com.pfuser.pojo.User
     */
    User checkUidDao(String uid);
}
