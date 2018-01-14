package com.tazine.aop.service;

import com.tazine.aop.security.CurrentUserHolder;
import org.springframework.stereotype.Service;

/**
 * Created by lina on 2018/1/14.
 *
 * @author frank
 * @since 1.0.0
 */
@Service
public class AuthService {

    public void checkAccess(){
        String user = CurrentUserHolder.get();
        if (!"admin".equalsIgnoreCase(user)){
            System.out.println("Operation Not Allowed.");
            throw new RuntimeException("Operation not allowed.");
        }
    }
}
