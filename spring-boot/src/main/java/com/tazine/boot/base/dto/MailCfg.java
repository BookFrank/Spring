package com.tazine.boot.base.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * spring-boot更新到1.5.2版本后locations属性无法使用
 * PropertySource注解只可以加载proprties文件,无法加载yaml文件
 *
 * @author frank
 * @since 1.0.0
 */
@Component
@ConfigurationProperties(prefix = "mail")
@PropertySource("classpath:mail.properties")
public class MailCfg {

    private String host;

    private String username;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
