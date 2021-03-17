package com.dpbinh.search.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

public class OrganizationDTO implements Serializable {
    protected Long id;
    protected String url;
    protected String externalId;
    protected OffsetDateTime createdAt;
    private String name;
    private List<String> domainNames;
    private String details;
    private Boolean sharedTickets;
    private List<String> ticketSubjects;
    private List<String> usernames;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

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

    public List<String> getTicketSubjects() {
        return ticketSubjects;
    }

    public void setTicketSubjects(List<String> ticketSubjects) {
        this.ticketSubjects = ticketSubjects;
    }

    public List<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(List<String> usernames) {
        this.usernames = usernames;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                "\nurl=" + url +
                "\nexternalId=" + externalId +
                "\ncreatedAt=" + createdAt +
                "\nname=" + name +
                "\ndomainNames=" + domainNames +
                "\ndetails=" + details +
                "\nsharedTickets=" + sharedTickets +
                "\nticketSubjects=" + ticketSubjects +
                "\nusernames=" + usernames ;
    }
}
