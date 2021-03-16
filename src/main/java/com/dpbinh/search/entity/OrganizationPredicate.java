package com.dpbinh.search.entity;

import java.util.function.Predicate;

public class OrganizationPredicate {
    public static Predicate<Organization> getSearchPredicate(String property, Object value) {
        return organization -> {
            return true;
        };
    }
}
