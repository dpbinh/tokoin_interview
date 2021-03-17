package com.dpbinh.search.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

public class UserDTO implements Serializable {
    protected Long id;
    protected String url;
    protected String externalId;
    protected OffsetDateTime createdAt;
    private String name;
    private String alias;
    private Boolean active;
    private Boolean verified;
    private Boolean shared;
    private String locale;
    private String timezone;
    private OffsetDateTime lastLoginAt;
    private String email;
    private String phone;
    private String signature;
    private Long organizationId;
    private Boolean suspended;
    private String role;
    private List<String> assigneeTicketSubjets;
    private List<String> submitterTicketSubjets;
    private String organizationName;

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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Boolean getShared() {
        return shared;
    }

    public void setShared(Boolean shared) {
        this.shared = shared;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public OffsetDateTime getLastLoginAt() {
        return lastLoginAt;
    }

    public void setLastLoginAt(OffsetDateTime lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Boolean getSuspended() {
        return suspended;
    }

    public void setSuspended(Boolean suspended) {
        this.suspended = suspended;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getAssigneeTicketSubjets() {
        return assigneeTicketSubjets;
    }

    public void setAssigneeTicketSubjets(List<String> assigneeTicketSubjets) {
        this.assigneeTicketSubjets = assigneeTicketSubjets;
    }

    public List<String> getSubmitterTicketSubjets() {
        return submitterTicketSubjets;
    }

    public void setSubmitterTicketSubjets(List<String> submitterTicketSubjets) {
        this.submitterTicketSubjets = submitterTicketSubjets;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                "\nurl= " + url +
                "\nexternalId= " + externalId +
                "\ncreatedAt=" + createdAt +
                "\nname=" + name +
                "\nalias=" + alias +
                "\nactive=" + active +
                "\nverified=" + verified +
                "\nshared=" + shared +
                "\nlocale=" + locale +
                "\ntimezone=" + timezone +
                "\nlastLoginAt=" + lastLoginAt +
                "\nemail=" + email +
                "\nphone=" + phone +
                "\nsignature=" + signature +
                "\norganizationId=" + organizationId +
                "\nsuspended=" + suspended +
                "\nrole=" + role +
                "\nassigneeTicketSubjets=" + assigneeTicketSubjets +
                "\nsubmitterTicketSubjets=" + submitterTicketSubjets +
                "\norganizationName='" + organizationName;
    }
}
