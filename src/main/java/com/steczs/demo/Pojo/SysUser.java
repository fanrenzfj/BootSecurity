package com.steczs.demo.Pojo;

import java.util.List;

public class SysUser {
    private String userName;
    private String password;
    private List<SysRole> roleList;

    @Override
    public String toString() {
        return "SysUser{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", roleList=" + roleList +
                '}';
    }

    public SysUser() {

    }

    public SysUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }
}
