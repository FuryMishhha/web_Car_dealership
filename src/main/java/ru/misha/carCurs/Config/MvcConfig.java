package ru.misha.carCurs.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("Login/login");
        registry.addViewController("/registration").setViewName("Login/registration");
        registry.addViewController("/admin").setViewName("Admin/admin");
        registry.addViewController("/admin/users").setViewName("Admin/admin_users");
        registry.addViewController("/admin/products").setViewName("Admin/admin_products");
        registry.addViewController("/catalog").setViewName("catalog");
        registry.addViewController("/account").setViewName("account");
        registry.addViewController("/admin/orders").setViewName("Admin/admin_orders");
    }
}
