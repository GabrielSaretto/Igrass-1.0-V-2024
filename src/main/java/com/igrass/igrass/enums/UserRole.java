package com.igrass.igrass.enums;

public enum UserRole {
    CLIENT("client"),
    PROVIDER("provider"),

    ADMIN("admin");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
