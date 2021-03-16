package com.dpbinh.search.entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum  OrganizationSearchEnum {
    ID(true),
    URL(true),
    EXTERNAL_ID(true),
    CREATED_AT(true),
    TAGS(true),
    NAME(true),
    DOMAIN_NAMES(true),
    DETAILS(true),
    SHARED_TICKETS(true);

    private boolean enabled;

    OrganizationSearchEnum(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public List<OrganizationSearchEnum> getAvailable() {
        return Arrays.asList(values()).stream().filter(p -> p.isEnabled()).collect(Collectors.toList());
    }
}
