package com.hbjy.carlocation.config;

import com.hbjy.carlocation.interceptor.CROSInterceptor;
import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Arrays;
import java.util.List;


@Configuration
@EnableTransactionManagement
@ImportResource("classpath:daos.xml")
@ComponentScan(basePackages = "com.hbjy.carlocation.controller")
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

   @Override
    public void addInterceptors(InterceptorRegistry registry) {
       //registry.addInterceptor(new ConstantsInterceptor());
       registry.addInterceptor(new LocaleChangeInterceptor());
//       registry.addInterceptor(new CROSInterceptor());
    }

    @Override
    public void addArgumentResolvers(
            List<HandlerMethodArgumentResolver> argumentResolvers) {
//        argumentResolvers.add(new SessionScopeArgumentResolver());
    }

    @Bean
    public DozerBeanMapper initDozerBeanMapper(){
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.setMappingFiles(Arrays.asList("dozer-mappers.xml"));

        return dozerBeanMapper;
    }

    /*@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/template/");
        resolver.setSuffix(".html");
        return resolver;
    }*/

    /**same as <mvc:default-servlet-handler/>*/
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @Bean(name = "localeResolver")
    public CookieLocaleResolver buidLocaleResolver(){
        CookieLocaleResolver localeResolver=new CookieLocaleResolver();
        localeResolver.setDefaultLocale(new java.util.Locale("en"));
        return localeResolver;
    }


}
