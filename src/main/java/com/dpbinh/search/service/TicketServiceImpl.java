package com.dpbinh.search.service;

import com.dpbinh.search.dto.TicketDTO;
import com.dpbinh.search.dto.mapper.TicketDTOMapper;
import com.dpbinh.search.entity.*;
import com.dpbinh.search.repository.OrganizationRepository;
import com.dpbinh.search.repository.TicketRepository;
import com.dpbinh.search.repository.UserRepository;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketDTOMapper ticketDTOMapper;

    @Override
    public List<TicketDTO> search(String property, String value) {
        Preconditions.checkArgument(property != null && !property.isEmpty(), "Input property is empty");
        Preconditions.checkArgument(value != null, "Input search value is null");

        TicketSearchEnum searchEnum = TicketSearchEnum.valueOf(property.toUpperCase());
        Preconditions.checkArgument(searchEnum != null && searchEnum.isEnabled(), "Invalid search property");

        Predicate predicate = TicketPredicate.getSearchPredicate(searchEnum, value);
        Set<Ticket> tickets = ticketRepository.findBy(predicate);

        List<TicketDTO> result = new ArrayList<>(tickets.size());

        for(Ticket ticket : tickets) {
            TicketDTO dto = ticketDTOMapper.toDTO(ticket);

            Optional<Organization> organizationOpt = organizationRepository.findOneById(ticket.getOrganizationId());
            if(organizationOpt.isPresent()) {
                dto.setOrganizationName(organizationOpt.get().getName());
            }

            Optional<User> assigneeOpt = userRepository.findOneById(ticket.getAssigneeId());
            if(assigneeOpt.isPresent()) {
                dto.setAssigneeName(assigneeOpt.get().getName());
            }

            Optional<User> submitterOpt = userRepository.findOneById(ticket.getSubmitterId());
            if(submitterOpt.isPresent()) {
                dto.setSubmitterName(submitterOpt.get().getName());
            }

            result.add(dto);
        }

        return result;
    }
}
