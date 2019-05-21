package com.steczs.demo.Pojo;

import java.util.List;

public class SysRole {
    private String code;
    private String name;
    private List<SysPermission>  permissionList;
     public SysRole() {
    }

    public SysRole(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SysPermission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<SysPermission> permissionList) {
        this.permissionList = permissionList;
    }
}
