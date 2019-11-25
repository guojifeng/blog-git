package cn.guojifeng.blog.service;

import cn.guojifeng.blog.domain.User;

import java.util.List;

public interface IUserService {

    void saveOrUpdate(User user);

    List<User> selectAll();

    User getUserById(int userId);

    void deleteUserById(int userId);

    User checkUsernameAndPassword(String username,String password);

}
