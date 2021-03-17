package com.dpbinh.search.dto.mapper;

import com.dpbinh.search.dto.OrganizationDTO;
import com.dpbinh.search.entity.Organization;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrganizationDTOMapper {
    OrganizationDTO toDTO(Organization entity);

    List<OrganizationDTO> toDTOs(List<Organization> entities);
}
