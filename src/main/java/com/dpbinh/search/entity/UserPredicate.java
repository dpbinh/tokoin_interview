package com.dpbinh.search.entity;

import com.dpbinh.search.util.DateTimeUtils;
import com.dpbinh.search.util.NumberUtils;

import java.util.function.Predicate;

public class UserPredicate {
    public static Predicate<User> getSearchPredicate(UserSearchEnum property, String value) {

        return user -> {

            switch (property) {
                case ID: return NumberUtils.isNumeric(value) && Long.valueOf(value).equals(user.getId());
                case ORGANIZATION_ID: return NumberUtils.isNumeric(value) && Long.valueOf(value).equals(user.getOrganizationId());
                case URL: return value.equalsIgnoreCase(user.getUrl());
                case CREATED_AT: return DateTimeUtils.parse(value).equals(user.getCreatedAt());
                case TAGS: return user.getTags() != null &&
                        user.getTags().stream().anyMatch(p -> p.equalsIgnoreCase(value));
                case EXTERNAL_ID: return value.equalsIgnoreCase(user.getExternalId());
                case NAME: return value.equalsIgnoreCase(user.getName());
                case ACTIVE: return value.equals(user.getActive());
                case ROLE: return value.equalsIgnoreCase(user.getRole());
                case ALIAS: return value.equalsIgnoreCase(user.getAlias());
                case EMAIL: return value.equalsIgnoreCase(user.getEmail());
                case LAST_LOGIN_AT: return DateTimeUtils.parse(value).equals(user.getLastLoginAt());
                case PHONE: return value.equalsIgnoreCase(user.getPhone());
                case LOCALE: return value.equalsIgnoreCase(user.getLocale());
                case SHARED: return Boolean.valueOf(value).equals(user.getShared());
                case SIGNATURE: return value.equalsIgnoreCase(user.getSignature());
                case TIMEZONE: return value.equalsIgnoreCase(user.getTimezone());
                case SUSPENDED: Boolean.valueOf(value).equals(user.getSuspended());
                case VERIFIED: Boolean.valueOf(value).equals(user.getVerified());

            }
            return false;
        };
    }
}
