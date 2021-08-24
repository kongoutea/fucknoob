package com.kongotea.fucknoob.mapper;

import com.kongotea.fucknoob.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    int save(User user);;
    int update(User user);
    User findById(String userFindId);
    List<User> findAll();
}
