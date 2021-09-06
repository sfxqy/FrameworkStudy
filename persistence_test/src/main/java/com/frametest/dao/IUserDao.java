package com.frametest.dao;

import com.frametest.pojo.User;
import java.util.List;

/**
 * @author sfx
 */
public interface IUserDao {


  List<User> findAll();


  List<User> findByCondition(User user);

}
