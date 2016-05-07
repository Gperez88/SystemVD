package com.perezmejia.systemvd.config;

import com.perezmejia.systemvd.config.template.ThymeleafLayoutInterceptor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Guil on 5/3/2016.
 */

@Configuration
@EnableJpaRepositories
public class AppConfig extends WebMvcConfigurerAdapter {
    /******************************************************************
     * THYMELEAF-SPECIFIC ARTIFACTS
     * TemplateResolver <- TemplateEngine <- ViewResolver
     *****************************************************************/
    @Bean(name = "templateResolver")
    public ServletContextTemplateResolver getTemplateResolver() {
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCacheable(true);
        return templateResolver;
    }

    @Bean(name = "templateEngine")
    public SpringTemplateEngine getTemplateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(getTemplateResolver());
        Set<IDialect> dialects = new HashSet<>();
        dialects.add(new SpringSecurityDialect());
        templateEngine.setAdditionalDialects(dialects);
        return templateEngine;
    }

    @Bean(name = "viewResolver")
    public ThymeleafViewResolver getViewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(getTemplateEngine());
        viewResolver.setOrder(1);
        viewResolver.setViewNames(new String[]{"*"});
        return viewResolver;
    }

    /*********************************************************************************************
     * ThymeleafLayoutInterceptor gets the original view name returned from the handler's method
     * and replaces it with the layout name.
     *********************************************************************************************/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ThymeleafLayoutInterceptor());
    }

    /******************************************************************
     * MESSAGE EXTERNALIZATION/INTERNATIONALIZATION
     * Standard Spring MessageSource implementation
     *****************************************************************/
    @Bean(name = "messageSource")
    public MessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
