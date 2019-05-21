package com.steczs.demo.Servcie.Impl;

import com.steczs.demo.Service.MyRbacService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component("MyRbacService")
public class MyRbacServiceImpl implements MyRbacService {
    private AntPathMatcher antPathMatcher=new AntPathMatcher();
    @Override
    public boolean findAuthority(HttpServletRequest request, Authentication authentication) {
        boolean authority=false;
        if (authentication.getPrincipal() instanceof UserDetails){
            String username = ((UserDetails) authentication.getPrincipal()).getUsername();
            //根据username去数据库查询对应的url,这里就不查了
            List<String> list =new ArrayList();
            for (String url:list){
                if (antPathMatcher.match(url,request.getRequestURI())){
                    authority=true;
                    break;
                }
            }
            return authority;
        }
        return authority;
    }
}
