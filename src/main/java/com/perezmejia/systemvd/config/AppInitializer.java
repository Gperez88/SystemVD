package com.perezmejia.systemvd.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * Created by Guil on 5/3/2016.
 */
public class AppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);

        configureDispatcherServlet(servletContext, rootContext);
        configureSpringSecurityFilter(servletContext);
    }

    private void configureDispatcherServlet(ServletContext servletContext, AnnotationConfigWebApplicationContext context) {
        context.setServletContext(servletContext);
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(context));
        dynamic.addMapping("/*");
        dynamic.setLoadOnStartup(1);
    }

    private void configureSpringSecurityFilter(ServletContext servletContext) {
        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
        FilterRegistration.Dynamic security = servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy());
        security.addMappingForUrlPatterns(dispatcherTypes, true, "/*");
    }
}
