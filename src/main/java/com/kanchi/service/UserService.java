package com.kanchi.service;

import com.kanchi.dto.User;

import java.util.List;

public interface UserService {

    public void addUser(User user);
    public List<User> getAllUsers();
    public User getUserById(int id);
    public void updateUser(User user);
    public void deleteUser(int id);

    public String getUserNameById(int id);
    public int getUserCount();

}
