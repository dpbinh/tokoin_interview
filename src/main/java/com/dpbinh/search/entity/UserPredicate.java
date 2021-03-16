package com.dpbinh.search.entity;

import java.util.function.Predicate;

public class UserPredicate {
    public static Predicate<User> getSearchPredicate(String property, Object value) {
        return user -> {
            return true;
        };
    }
}
