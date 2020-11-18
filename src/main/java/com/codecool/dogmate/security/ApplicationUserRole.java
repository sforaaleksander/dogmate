package com.codecool.dogmate.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.codecool.dogmate.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    USER(Sets.newHashSet()),
    PREMIUM_USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(BREED_READ,
            BREED_WRITE,
            COORDINATES_READ,
            COORDINATES_WRITE,
            DOG_READ,
            DOG_WRITE,
            FRIENDS_READ,
            FRIENDS_WRITE,
            LOGIN_ATTEMPT_READ,
            LOGIN_ATTEMPT_WRITE,
            MESSAGE_READ,
            MESSAGE_WRITE,
            SESSION_READ,
            SESSION_WRITE,
            TEMPER_READ,
            TEMPER_WRITE,
            USER_READ,
            USER_WRITE,
            WALK_READ,
            WALK_WRITE,
            WALK_AREA_READ,
            WALK_AREA_WRITE,
            WALK_STATUS_READ,
            WALK_STATUS_WRITE,
            USER_TYPE_READ,
            USER_TYPE_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
