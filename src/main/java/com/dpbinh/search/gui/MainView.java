package com.dpbinh.search.gui;

import com.dpbinh.search.dto.OrganizationDTO;
import com.dpbinh.search.dto.TicketDTO;
import com.dpbinh.search.dto.UserDTO;
import com.dpbinh.search.service.OrganizationService;
import com.dpbinh.search.service.TicketService;
import com.dpbinh.search.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class MainView implements View {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @Override
    public void draw(Map<String, Object> params) {
        System.out.println("Type 'quit' to exit at any time, Press 'Enter' to continue\n\n");
        System.out.println("\t\tSelect search options:");
        System.out.println("\t\t - Press 1 to search");
        System.out.println("\t\t - Press 2 to view a list of searchable fields");
        System.out.println("\t\t - Type 'quit' to exit");

        List<OrganizationDTO> organizationDTOS = organizationService.search("ID", "101");
        System.out.println(organizationDTOS);

        List<TicketDTO> ticketDTOS = ticketService.search("ID", "436bf9b0-1147-4c0a-8439-6f79833bff5b");
        System.out.println(ticketDTOS);

        List<UserDTO> userDTOS = userService.search("ID", "1");
        System.out.println(userDTOS);

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
