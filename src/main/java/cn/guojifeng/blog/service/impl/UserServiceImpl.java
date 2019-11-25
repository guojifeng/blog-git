package cn.guojifeng.blog.service.impl;

import cn.guojifeng.blog.domain.User;

import cn.guojifeng.blog.mapper.UserMapper;
import cn.guojifeng.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveOrUpdate(User user) {
        if (user.getId()==null){
            userMapper.insert(user);
        }else {
            userMapper.updateByPrimaryKey(user);
        }
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public User getUserById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void deleteUserById(int userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public User checkUsernameAndPassword(String username, String password) {
        return userMapper.selectUserByUsernameAndPassword(username,password);
    }
}
