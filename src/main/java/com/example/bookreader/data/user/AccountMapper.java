package com.example.bookreader.data.user;

import com.example.bookreader.po.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AccountMapper {
    int createNewAccount(User user);

    User getAccountByName(@Param("name") String name);

    User getAccountById(@Param("id") int id);

    int updateAccount(@Param("id") int id, @Param("password") String password,@Param("userName") String username, @Param("phoneNumber") String phonenumber);



}
