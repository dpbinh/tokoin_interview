package com.dpbinh.search.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class TicketDTO implements Serializable {
    protected String id;
    protected String url;
    protected String externalId;
    protected OffsetDateTime createdAt;
    private String type;
    private String subject;
    private String description;
    private String priority;
    private String status;
    private Long submitterId;
    private Long assigneeId;
    private Long organizationId;
    private Boolean hasIncidents;
    private OffsetDateTime dueAt;
    private String via;
    private String assigneeName;
    private String submitterName;
    private String organizationName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getSubmitterId() {
        return submitterId;
    }

    public void setSubmitterId(Long submitterId) {
        this.submitterId = submitterId;
    }

    public Long getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(Long assigneeId) {
        this.assigneeId = assigneeId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Boolean getHasIncidents() {
        return hasIncidents;
    }

    public void setHasIncidents(Boolean hasIncidents) {
        this.hasIncidents = hasIncidents;
    }

    public OffsetDateTime getDueAt() {
        return dueAt;
    }

    public void setDueAt(OffsetDateTime dueAt) {
        this.dueAt = dueAt;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public void setSubmitterName(String submitterName) {
        this.submitterName = submitterName;
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
                "\nurl=" + url +
                "\nexternalId=" + externalId +
                "\ncreatedAt=" + createdAt +
                "\ntype=" + type +
                "\nsubject=" + subject +
                "\ndescription=" + description +
                "\npriority=" + priority +
                "\nstatus=" + status +
                "\nsubmitterId=" + submitterId +
                "\nassigneeId=" + assigneeId +
                "\norganizationId=" + organizationId +
                "\nhasIncidents=" + hasIncidents +
                "\ndueAt=" + dueAt +
                "\nvia=" + via +
                "\nassigneeName=" + assigneeName +
                "\nsubmitterName=" + submitterName +
                "\norganizationName=" + organizationName;
    }
}
