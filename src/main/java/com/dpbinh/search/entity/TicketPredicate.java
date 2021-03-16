package com.dpbinh.search.entity;

import java.util.function.Predicate;

public class TicketPredicate {

    public static  Predicate<Ticket> getSearchPredicate(final String property, final Object value) {
         return ticket -> {
            return true;
         };
    }
}
