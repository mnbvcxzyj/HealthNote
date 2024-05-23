
package com.sosigae.LuckeyTurkey.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sosigae.LuckeyTurkey.domain.User;

@Repository
@Mapper
public interface UserDao {

	User loginMember(@Param("user_id") String user_id, @Param("password") String password);

    void registerMember(User user);

    void deleteMember(User user);

    void updateMember(User user);

    int isValidUser(String user_id, String password);
}