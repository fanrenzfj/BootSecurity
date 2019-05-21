package com.steczs.demo.Service;


import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface MyRbacService {
    boolean findAuthority(HttpServletRequest request, Authentication authentication);
}

