package com.edu.repository;

import com.edu.pojo.User;
import java.util.List;


public interface UserRepository {
     User getUserById(int id);
     List<User> getUsers(String username);
}
