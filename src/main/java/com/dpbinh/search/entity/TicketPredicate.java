package com.dpbinh.search.entity;

import com.dpbinh.search.util.DateTimeUtils;
import com.dpbinh.search.util.NumberUtils;

import java.util.function.Predicate;

public class TicketPredicate {

    public static Predicate<Ticket> getSearchPredicate(final TicketSearchEnum property, final String value) {

        return ticket -> {

            switch (property) {
                case ID: return value.equalsIgnoreCase(ticket.getId());
                case ORGANIZATION_ID: return NumberUtils.isNumeric(value) && Long.valueOf(value).equals(ticket.getOrganizationId());
                case URL: return  value.equalsIgnoreCase(ticket.getUrl());
                case VIA: return value.equalsIgnoreCase(ticket.getVia());
                case TAGS: return ticket.getTags() != null &&
                        ticket.getTags().stream().anyMatch(p -> p.equalsIgnoreCase(value));
                case TYPE: return value.equalsIgnoreCase(ticket.getType());
                case DUE_AT: return  DateTimeUtils.parse(value).equals(ticket.getDueAt());
                case STATUS: return value.equalsIgnoreCase(ticket.getStatus());
                case SUBJECT: return value.equalsIgnoreCase(ticket.getSubject());
                case PRIORITY: return value.equalsIgnoreCase(ticket.getPriority());
                case CREATED_AT: return  DateTimeUtils.parse(value).equals(ticket.getCreatedAt());
                case ASSIGNEE_ID: return NumberUtils.isNumeric(value) && Long.valueOf(value).equals(ticket.getAssigneeId());
                case DESCRIPTION: return value.equalsIgnoreCase(ticket.getDescription());
                case EXTERNAL_ID: return value.equalsIgnoreCase(ticket.getExternalId());
                case SUBMITTER_ID: return NumberUtils.isNumeric(value) && Long.valueOf(value).equals(ticket.getSubmitterId());
                case HAS_INCIDENTS: return Boolean.valueOf(value).equals(ticket.getHasIncidents());
            }
            return false;
        };
    }
}
