package com.dpbinh.search.repository;

import com.dpbinh.search.config.AppSetting;
import com.dpbinh.search.domain.Organization;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OrganizationRepositoryImpl extends BaseRepositoryImpl<Organization> {

    public OrganizationRepositoryImpl(AppSetting appSetting) throws IOException {
        super(appSetting.getOrganizationFilePath());
    }
}
