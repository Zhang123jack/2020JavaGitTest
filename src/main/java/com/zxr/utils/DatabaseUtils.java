package com.zxr.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseUtils implements ServletContextListener {
    private static DataSource ds=null;

    public static DataSource getDataSource() {
        return ds;
    }
    public static JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate;
    }
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        InputStream resourceAsStream = servletContext.getResourceAsStream("WEB-INF/database.properties");
        Properties p=new Properties();
        try {
            p.load(resourceAsStream);
            ds = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
