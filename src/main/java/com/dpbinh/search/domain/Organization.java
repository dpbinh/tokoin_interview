package com.dpbinh.search.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

public class Organization extends BaseEntity<Long> {

    @JsonProperty("name")
    private String name;

    @JsonProperty("domain_names")
    private List<String> domainNames;

    @JsonProperty("details")
    private String details;

    @JsonProperty("shared_tickets")
    private Boolean sharedTickets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDomainNames() {
        return domainNames;
    }

    public void setDomainNames(List<String> domainNames) {
        this.domainNames = domainNames;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Boolean getSharedTickets() {
        return sharedTickets;
    }

    public void setSharedTickets(Boolean sharedTickets) {
        this.sharedTickets = sharedTickets;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "name='" + name + '\'' +
                ", domainNames=" + domainNames +
                ", details='" + details + '\'' +
                ", sharedTickets=" + sharedTickets +
                ", id=" + id +
                ", url='" + url + '\'' +
                ", externalId='" + externalId + '\'' +
                ", createdAt=" + createdAt +
                ", tags=" + tags +
                '}';
    }
}
