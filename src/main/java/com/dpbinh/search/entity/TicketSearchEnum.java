package com.dpbinh.search.entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum TicketSearchEnum {
    ID(true),
    URL(true),
    EXTERNAL_ID(true),
    CREATED_AT(true),
    TAGS(true),
    TYPE(true),
    SUBJECT(true),
    DESCRIPTION(true),
    PRIORITY(true),
    STATUS(true),
    SUBMITTER_ID(true),
    ASSIGNEE_ID(true),
    ORGANIZATION_ID(true),
    HAS_INCIDENTS(true),
    DUE_AT(true),
    VIA(true);

    private boolean enabled;

    TicketSearchEnum(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public static List<TicketSearchEnum> getAvailable() {
        return Arrays.asList(values()).stream().filter(p -> p.isEnabled()).collect(Collectors.toList());
    }
}
