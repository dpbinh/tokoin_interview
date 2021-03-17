package com.dpbinh.search.service;

import com.dpbinh.search.dto.TicketDTO;
import com.dpbinh.search.dto.UserDTO;
import com.dpbinh.search.dto.mapper.UserDTOMapper;
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
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDTOMapper userDTOMapper;

    @Override
    public List<UserDTO> search(String property, String value) {
        Preconditions.checkArgument(property != null && !property.isEmpty(), "Input property is empty");
        Preconditions.checkArgument(value != null, "Input search value is null");

        UserSearchEnum searchEnum = UserSearchEnum.valueOf(property.toUpperCase());
        Preconditions.checkArgument(searchEnum != null && searchEnum.isEnabled(), "Invalid search property");

        Predicate predicate = UserPredicate.getSearchPredicate(searchEnum, value);
        Set<User> users = userRepository.findBy(predicate);

        List<UserDTO> result = new ArrayList<>(users.size());

        for(User user : users) {
            UserDTO dto = userDTOMapper.toDTO(user);

            Optional<Organization> organizationOpt = organizationRepository.findOneById(user.getOrganizationId());
            if(organizationOpt.isPresent()) {
                dto.setOrganizationName(organizationOpt.get().getName());
            }

            Predicate assigneePredicate = TicketPredicate.getSearchPredicate(TicketSearchEnum.ASSIGNEE_ID, String.valueOf(user.getId()));
            Set<Ticket> assigneeTickets = ticketRepository.findBy(assigneePredicate);
            if(assigneeTickets != null) {
                dto.setAssigneeTicketSubjets(assigneeTickets.stream().map(Ticket::getSubject).collect(Collectors.toList()));
            }

            Predicate submitterPredicate = TicketPredicate.getSearchPredicate(TicketSearchEnum.SUBMITTER_ID, String.valueOf(user.getId()));
            Set<Ticket> submitterTickets = ticketRepository.findBy(submitterPredicate);
            if(submitterTickets != null) {
                dto.setSubmitterTicketSubjets(submitterTickets.stream().map(Ticket::getSubject).collect(Collectors.toList()));
            }

            result.add(dto);
        }

        return result;
    }
}
