package com.dpbinh.search.service;

import com.dpbinh.search.dto.OrganizationDTO;

import java.util.List;

public interface OrganizationService {
    List<OrganizationDTO> search(String property, String value);
}
