package com.dpbinh.search.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppSetting {

    @Value("${data.users.path}")
    private String userFilePath;

    @Value("${data.organizations.path}")
    private String organizationFilePath;

    @Value("${data.tickets.path}")
    private String ticketFilePath;

    public String getUserFilePath() {
        return userFilePath;
    }

    public String getOrganizationFilePath() {
        return organizationFilePath;
    }

    public String getTicketFilePath() {
        return ticketFilePath;
    }
}
