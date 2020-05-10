package com.example.bookreader.bl.user;


import com.example.bookreader.po.user.User;
import com.example.bookreader.vo.ResponseVO;
import com.example.bookreader.vo.UserForm;
import com.example.bookreader.vo.UserVO;

/**
 * @author huwen
 * @date 2019/3/23
 */
public interface AccountService {

    /**
     * 注册账号
     *
     * @return
     */
    ResponseVO registerAccount(UserVO userVO);

    /**
     * 用户登录，登录成功会将用户信息保存再session中
     *
     * @return
     */
    User login(UserForm userForm);

    /**
     * 获取用户个人信息
     * @param id
     * @return
     */
    User getUserInfo(int id);

    /**
     * 更新用户个人信息
     * @param id
     * @param password
     * @param username
     * @param phonenumber
     * @return
     */
    ResponseVO updateUserInfo(int id, String password,String username,String phonenumber);


}

