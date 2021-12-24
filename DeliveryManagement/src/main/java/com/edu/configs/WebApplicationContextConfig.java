// Cấu hình tất cả nội dung khác sử dụng trên web
package com.edu.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.edu.formatter.AuctionFormatter;
import com.edu.formatter.OrderFormatter;
import com.edu.formatter.ShipperFormatter;
import com.edu.validator.UsernameValidator;
import com.edu.validator.WebAppValidator;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.edu.controller",
    "com.edu.repository",
    "com.edu.service",
    "com.edu.validator"
})
public class WebApplicationContextConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // Khai báo tài nguyên tĩnh cho hệ thống
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Thứ tự là đường dẫn lập trình ở ngoài - đường dẫn trong hệ thống
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/resources/css/");
        registry.addResourceHandler("/images/**")
                .addResourceLocations("/resources/images/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("/resources/js/");
    }

    // Thêm, khai báo formatter dữ liệu
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //registry.addFormatter(new YourFormatter());
        registry.addFormatter(new OrderFormatter());
        registry.addFormatter(new AuctionFormatter());
        registry.addFormatter(new ShipperFormatter());
    }

    // Override validator của webmvcconfig có sẵn, xong khai báo của mình
    @Override
    public Validator getValidator() {
        return validator();
    }
    
    @Bean
    public WebAppValidator userValidator() {
        WebAppValidator v = new WebAppValidator();
        
        Set<Validator> springsValidators = new HashSet<>();
        
        springsValidators.add(new UsernameValidator());
        v.setSpringValidators(springsValidators);
        
        return v;
    }

    // Cấu hình validator của lớp product
//    @Bean
//    public WebAppValidator productValidator() {
//        Set<Validator> springValidators = new HashSet<>();
//        springValidators.add(new ProductNameValidator());
//        WebAppValidator v = new WebAppValidator();
//        v.setSpringValidator(springValidators);
//        return v;
//    }
    // Cấu hình bean validator, message trả ra đọc từ file properties
    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean v = new LocalValidatorFactoryBean();
        v.setValidationMessageSource(messageSource());
        return v;
    }

    // Cấu hình đọc message từ file properties
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        return source;
    }

    // Cấu hình để xử lý các file JSP thành view thông qua Jstl
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resource = new InternalResourceViewResolver();
        // Trỏ đến lớp hỗ trợ xử lý file jsp
        resource.setViewClass(JstlView.class);
        // Trỏ đến thư mục chứa các file jsp
        resource.setPrefix("/WEB-INF/jsp/");
        // Chỉ định phần đuôi mở rộng được xử lý
        resource.setSuffix(".jsp");
        return resource;
    }
    
    // Cấu hình bean để xử lý upload ảnh và file
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }
    
    // Cấu hình kết nối với media server Cloudinary để upload
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
}
