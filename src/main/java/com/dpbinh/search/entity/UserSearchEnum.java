package com.dpbinh.search.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum UserSearchEnum {
    ID(true),
    URL(true),
    EXTERNAL_ID(true),
    CREATED_AT(true),
    TAGS(true),
    NAME(true),
    ALIAS(true),
    ACTIVE(true),
    VERIFIED(true),
    SHARED(true),
    LOCALE(true),
    TIMEZONE(true),
    LAST_LOGIN_AT(true),
    EMAIL(true),
    PHONE(true),
    SIGNATURE(true),
    ORGANIZATION_ID(true),
    SUSPENDED(true),
    ROLE(true);

    private boolean enabled;

    UserSearchEnum(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public List<UserSearchEnum> getAvailable() {
        return Arrays.asList(values()).stream().filter(p -> p.isEnabled()).collect(Collectors.toList());
    }
}
