// Config bean để sử dụng tiles cho các template view
package com.edu.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class TilesConfig {

    // Cấu hình khởi tạo view theo tiles
    @Bean
    public UrlBasedViewResolver viewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        // Sử dụng thư viện được cung cấp, có sẵn
        resolver.setViewClass(TilesView.class);
        // Hệ thống cho phép nhiều view resolver, số càng nhỏ độ ưu tiên càng cao
        resolver.setOrder(-2);
        return resolver;
    }

    // Cấu hình trỏ đến vị trí file xml để sử dụng tiles
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer c = new TilesConfigurer();
        c.setDefinitions("/WEB-INF/tiles.xml");
        c.setCheckRefresh(true);
        return c;
    }
}
