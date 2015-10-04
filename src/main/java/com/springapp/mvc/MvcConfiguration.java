package com.springapp.mvc;

import com.springapp.mvc.dao.VareDAO;
import com.springapp.mvc.dao.VareDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

/**
 * Created by benny on 29.09.15.
 */

// Denner erstatter servlet.xml


@Configuration
@ComponentScan(basePackages = {"com.springapp.mvc"})
@EnableWebMvc

public class MvcConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }


    //Leter etter resources mappen for å finne css filen
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }


    //Setter opp bean for databasetilkobling
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://89.162.102.115:3306/oblig");
        dataSource.setUsername("oblig");
        dataSource.setPassword("oblig");

        return dataSource;
    }

    @Bean
    public VareDAO getVareDAO() {
        return new VareDAOImpl(getDataSource());
    }


}
