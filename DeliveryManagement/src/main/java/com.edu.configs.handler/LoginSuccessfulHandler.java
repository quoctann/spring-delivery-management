package com.edu.configs;

import com.edu.pojo.User;
import com.edu.service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

// Khai báo bằng @Bean rồi thì ko cần khai báo component nữa
public class LoginSuccessfulHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserService userDetailsService;
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
        // Lưu dữ liệu user trước khi đăng nhập nó vào
        // Đối tượng auth của spring secu chỉ lưu username thôi
        User u = this.userDetailsService.getUsers(auth.getName()).get(0);
        // Lưu dữ liệu vào session
        request.getSession().setAttribute("currentUser", u);
        response.sendRedirect("/DeliveryManagement");
    }
    
}
