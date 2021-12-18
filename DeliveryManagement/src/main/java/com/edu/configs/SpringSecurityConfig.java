// Cấu hình Spring security, chứng thực, phân quyền, mã hóa mật khẩu
package com.edu.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// Extends lại web security có sẵn
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.edu.repository",
    "com.edu.service"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    // Biến user được dùng để xác thực, tên này được khai báo giống với ở UserServiceImpl
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationSuccessHandler loginSuccessHandler;
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;
    
    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        // Tạo đối tượng bằng bean trỏ đến handler của mình
        return new LoginSuccessfulHandler();
    }
    
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        // Tạo đối tượng bằng bean trỏ đến handler của mình
        return new LogoutSuccessfulHandler();
    }
    
    // Cách thức mã hóa mật khẩu trước khi ghi vào csdl
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    // Nạp cloudinary luôn để scan không bị lỗi
    @Bean
    public Cloudinary cloudinary() {
        Cloudinary c = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "open-edu",
            "api_key", "146256471874449",
            "api_secret", "DngyGbiJtXwvStyV7r_pbfa8St8",
            "secure", true    
        ));
        return c;
    }
    
    // Chứng thực
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Sử dụng user details vừa autowired, cách mã hóa ở trên luôn
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    // Phân quyền truy cập
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Liên kết form login của mình vào spring security
        http.formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password");
        
        // Nếu đăng nhập thành công hoặc thất bại thì redirect đến url
        http.formLogin().defaultSuccessUrl("/").failureUrl("/login?error");
        
        // Khi đăng nhập thành công thì nó sẽ gọi phương thức tùy chỉnh (lưu user data vào session)
        http.formLogin().successHandler(this.loginSuccessHandler);
        
//        http.logout().logoutSuccessUrl("/login");
        // Xóa user data ra khỏi session khi đăng xuất
        http.logout().logoutSuccessHandler(this.logoutSuccessHandler);
        
        // Khi không có quyền sẽ trả ra cái cờ
        http.exceptionHandling().accessDeniedPage("/login?accessDenied");
        
        // Đăng nhập thành công bắt đầu phân quyền các endpoint với các quyền tương ứng
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").access("hasRole('admin')")
                .antMatchers("/shipper/**").access("hasRole('shipper')")
                .antMatchers("/customer/**").access("hasRole('customer')");
        
        // Khi gửi form nó tự bật để tránh bị chèn mã độc, tắt để chạy chương trình
        http.csrf().disable();
    }
}
