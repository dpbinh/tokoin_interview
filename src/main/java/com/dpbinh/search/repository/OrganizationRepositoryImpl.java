package com.dpbinh.search.repository;

import com.dpbinh.search.config.AppSetting;
import com.dpbinh.search.domain.Organization;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class OrganizationRepositoryImpl extends BaseRepositoryImpl<Organization> {

    public OrganizationRepositoryImpl(AppSetting appSetting) throws IOException {
        super(appSetting.getOrganizationFilePath(), new TypeReference<List<Organization>>() {});
    }
}
