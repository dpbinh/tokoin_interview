package com.dpbinh.search.service;

import com.dpbinh.search.dto.OrganizationDTO;
import com.dpbinh.search.dto.mapper.OrganizationDTOMapper;
import com.dpbinh.search.entity.*;
import com.dpbinh.search.repository.OrganizationRepository;
import com.dpbinh.search.repository.TicketRepository;
import com.dpbinh.search.repository.UserRepository;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrganizationDTOMapper organizationDTOMapper;

    public List<OrganizationDTO> search(String property, String value) {
        Preconditions.checkArgument(property != null && !property.isEmpty(), "Input property is empty");
        Preconditions.checkArgument(value != null, "Input search value is null");

        OrganizationSearchEnum searchEnum = OrganizationSearchEnum.valueOf(property.toUpperCase());
        Preconditions.checkArgument(searchEnum != null && searchEnum.isEnabled(), "Invalid search property");

        Predicate predicate = OrganizationPredicate.getSearchPredicate(searchEnum, value);
        Set<Organization> organizations = organizationRepository.findBy(predicate);

        List<OrganizationDTO> result = new ArrayList<>(organizations.size());

        for(Organization organization : organizations) {
            OrganizationDTO dto = organizationDTOMapper.toDTO(organization);

            Predicate ticketPredicate = TicketPredicate.getSearchPredicate(TicketSearchEnum.ORGANIZATION_ID, String.valueOf(organization.getId()));
            Set<Ticket> tickets = ticketRepository.findBy(ticketPredicate);
            if(tickets != null) {
                dto.setTicketSubjects(tickets.stream().map(Ticket::getSubject).collect(Collectors.toList()));
            }

            Predicate userPredicate = UserPredicate.getSearchPredicate(UserSearchEnum.ORGANIZATION_ID, String.valueOf(organization.getId()));
            Set<User> users = userRepository.findBy(userPredicate);
            if(users != null) {
                dto.setUsernames(users.stream().map(User::getName).collect(Collectors.toList()));
            }

            result.add(dto);
        }

        return result;
    }

}
