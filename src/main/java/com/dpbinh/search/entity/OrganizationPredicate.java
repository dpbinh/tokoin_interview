package com.dpbinh.search.entity;

import com.dpbinh.search.util.DateTimeUtils;
import com.dpbinh.search.util.NumberUtils;

import java.util.function.Predicate;

public class OrganizationPredicate {
    public static Predicate<Organization> getSearchPredicate(OrganizationSearchEnum property, String value) {
        return organization -> {

            switch (property) {
                case ID: return NumberUtils.isNumeric(value) && Long.valueOf(value) .equals(organization.getId());
                case URL: return value.equalsIgnoreCase(organization.getUrl());
                case CREATED_AT: return DateTimeUtils.parse(value).equals(organization.getCreatedAt());
                case TAGS: return organization.getTags() != null &&
                        organization.getTags().stream().anyMatch(p -> p.equalsIgnoreCase(value));
                case EXTERNAL_ID: return value.equalsIgnoreCase(organization.getExternalId());
                case NAME: return value.equalsIgnoreCase(organization.getName());
                case DETAILS: return value.equalsIgnoreCase(organization.getDetails());
                case DOMAIN_NAMES: return organization.getDomainNames() != null &&
                        organization.getDomainNames().stream().anyMatch(p -> p.equalsIgnoreCase(value));
                case SHARED_TICKETS: return Boolean.valueOf(value).equals(organization.getSharedTickets());
            }
            return false;
        };
    }
}
