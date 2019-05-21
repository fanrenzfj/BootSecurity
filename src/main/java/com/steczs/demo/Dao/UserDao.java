package com.steczs.demo.Dao;

import com.steczs.demo.Pojo.SysPermission;
import com.steczs.demo.Pojo.SysRole;
import com.steczs.demo.Pojo.SysUser;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class UserDao {
    private SysRole admin = new SysRole("ADMIN", "管理员");
    private SysRole developer = new SysRole("DEVELOPER", "开发者");

    {
         SysPermission p1 = new SysPermission();
         p1.setCode("UserIndex");
         p1.setName("个人中心");
         p1.setUrl("/user/index.html");

         SysPermission p2 = new SysPermission();
         p2.setCode("BookList");
         p2.setName("图书列表");
         p2.setUrl("/book/list");

         SysPermission p3 = new SysPermission();
         p3.setCode("BookAdd");
         p3.setName("添加图书");
         p3.setUrl("/book/add");

         SysPermission p4 = new SysPermission();
         p4.setCode("BookDetail");
         p4.setName("查看图书");
         p4.setUrl("/book/detail");

         admin.setPermissionList(Arrays.asList(p1, p2, p3, p4));
         developer.setPermissionList(Arrays.asList(p1, p2));


    }



    public SysUser selectByName(String username) {
         //从数据库中查询用户
         if ("zhangsan".equals(username)) {

            SysUser sysUser = new SysUser("zhangsan", "1234");
             sysUser.setRoleList(Arrays.asList(admin, developer));
             return sysUser;

        } else if ("lisi".equals(username)) {
             SysUser sysUser = new SysUser("lisi", "$2a$10$EIfFrWGINQzP.tmtdLd2hurtowwsIEQaPFR9iffw2uSKCOutHnQEm");
             sysUser.setRoleList(Arrays.asList(developer));
             return sysUser;

        }
         return null;

    }

}
