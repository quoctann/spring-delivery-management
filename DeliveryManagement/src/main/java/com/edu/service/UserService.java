package com.edu.service;

import com.edu.pojo.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    User getUserById(int id);
    List<User> getUsers(String username);
    boolean addUser(User user);
    boolean updateInfo(User user);
}
