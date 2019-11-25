package cn.guojifeng.blog.mapper;

import cn.guojifeng.blog.domain.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);


    User selectUserByUsernameAndPassword(String username, String password);
}