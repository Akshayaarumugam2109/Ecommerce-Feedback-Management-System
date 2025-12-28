package com.examly.springapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "app")
    public ApplicationProperties applicationProperties() {
        return new ApplicationProperties();
    }

    public static class ApplicationProperties {
        private String name = "E-commerce Feedback Management System";
        private String version = "1.0.0";
        private int defaultPageSize = 10;
        private int maxPageSize = 100;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        
        public String getVersion() { return version; }
        public void setVersion(String version) { this.version = version; }
        
        public int getDefaultPageSize() { return defaultPageSize; }
        public void setDefaultPageSize(int defaultPageSize) { this.defaultPageSize = defaultPageSize; }
        
        public int getMaxPageSize() { return maxPageSize; }
        public void setMaxPageSize(int maxPageSize) { this.maxPageSize = maxPageSize; }
    }
}