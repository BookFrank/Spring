package com.tazine.boot.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.beans.PropertyVetoException;

/**
 * Created by lina on 2018/2/7.
 *
 * @author frank
 * @since 1.0.0
 */
public class DataSourceConfiguration {

    //@Autowired
    private Environment env;

    private String jdbcDriver = env.getProperty("jdbc.driver");
    private String jdbcUrl = env.getProperty("jdbc.url");
    private String jdbcUser = env.getProperty("jdbc.user");
    private String jdbcPassword = env.getProperty("jdbc.password");

    //@Bean(name = "dataSource")
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        System.out.println(jdbcDriver);
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUser);
        dataSource.setPassword(jdbcPassword);
        /**
         * 关闭连接的时候是否自动提交，方便事务控制
         */
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}
