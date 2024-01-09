package com.example.demo.service;

import com.example.demo.entity.User;
import jdk.internal.net.http.LineSubscriberAdapter;

import java.util.List;

public interface UserService {
//    根据id查询用户
    public User findByid(String id);

    public List<User> findAlluser();
//  添加用户
    public boolean addUser(User user);
//    修改用户
    public boolean  updateUser(User user);
//    删除用户
    public boolean delUser(String id);
}
