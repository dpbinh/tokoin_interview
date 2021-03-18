package com.dpbinh.search.gui;

import com.dpbinh.search.config.Constants;
import com.dpbinh.search.service.OrganizationService;
import com.dpbinh.search.service.TicketService;
import com.dpbinh.search.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Component
public class SearchView implements View {
    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @Override
    public ViewName getName() {
        return ViewName.SEARCH;
    }

    @Override
    public void draw(ViewFactory viewFactory, Map<String, Object> params) throws Exception {
        System.out.println("Select 1) Users or 2) Tickets or 3) Organizations");

        Scanner scanner = new Scanner(System.in);
        String selected = scanner.nextLine();

        System.out.println("Enter search term");
        String property = scanner.nextLine();

        System.out.println("Enter search value");
        String value = scanner.nextLine();

        List searchResult = null;

        switch (selected) {
            case "1": {
                searchResult = userService.search(property, value);
            } break;
            case "2": {
                searchResult = ticketService.search(property, value);
            } break;
            case "3": {
                searchResult = organizationService.search(property, value);
            } break;
        }

        Map<String, Object> nextParams = new HashMap<>();
        nextParams.put(Constants.SEARCH_RESULT_DATA, searchResult);
        viewFactory.getView(ViewName.SEARCH_RESULT).draw(viewFactory, nextParams);
    }
}
