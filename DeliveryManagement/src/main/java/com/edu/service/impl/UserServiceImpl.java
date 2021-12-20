package com.edu.service.impl;

import com.edu.pojo.User;
import com.edu.repository.UserRepository;
import com.edu.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetailsService")
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public User getUserById(int id) {
        return this.userRepository.getUserById(id);
    }
    
    @Override
    public List<User> getUsers(String username) {
        return this.userRepository.getUsers(username);
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Do so sánh equal nên dù trả ra kiểu list nhưng nó vẫn chỉ có một phần tử
        List<User> users = this.getUsers(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("User doesn't exist!");
        }
        User user = users.get(0);
        // Kiểm tra quyền sử dụng người dùng
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(user.getUserRole()));
        
        // Trả về người dùng là đối tượng user từ spring secu
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), auth);
    }
  
}
