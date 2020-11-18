package com.codecool.dogmate.security;

public enum ApplicationUserPermission {
    BREED_READ("breed:read"),
    BREED_WRITE("breed:write"),
    COORDINATES_READ("coordinates:read"),
    COORDINATES_WRITE("coordinates:write"),
    DOG_READ("dog:read"),
    DOG_WRITE("dog:write"),
    FRIENDS_READ("friends:read"),
    FRIENDS_WRITE("friends:write"),
    LOGIN_ATTEMPT_READ("login_attempt:read"),
    LOGIN_ATTEMPT_WRITE("login_attempt:write"),
    MESSAGE_READ("message:read"),
    MESSAGE_WRITE("message:write"),
    SESSION_READ("session:read"),
    SESSION_WRITE("session:write"),
    TEMPER_READ("temper:read"),
    TEMPER_WRITE("temper:write"),
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    WALK_READ("walk:read"),
    WALK_WRITE("walk:write"),
    WALK_AREA_READ("walk_area:read"),
    WALK_AREA_WRITE("walk_area:write"),
    WALK_STATUS_READ("walk_status:read"),
    WALK_STATUS_WRITE("walk_status:write"),
    USER_TYPE_READ("user_type:read"),
    USER_TYPE_WRITE("user_type:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
