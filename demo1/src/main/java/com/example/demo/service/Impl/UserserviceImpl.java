package com.example.demo.service.Impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserserviceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByid(String id) {
        User user = userMapper.findById(id).orElse(null);
        return user;
    }

    @Override
    public List<User> findAlluser() {
        return userMapper.findAll();
    }

    @Override
    public boolean addUser(User user) {
        User user1 = new User();
        user1 = userMapper.save(user);
        if (!user1.getId().equals("")) {
            System.out.println("添加用户成功");
            return true;
        }
            return false;
    }

    @Override
    public boolean updateUser(User user) {
        User user1 = userMapper.findById(user.getId()).orElse(null);
        if (user1!= null) {
            userMapper.save(user);
            System.out.println("更新用户成功");
            return true;
        }
        return false;
    }

    @Override
    public boolean delUser(String id) {
        User user = userMapper.findById(id).orElse(null);
        if (user!= null) {
            userMapper.delete(user);
            System.out.println("删除用户成功");
            return true;
        }
        return false;
    }
}
