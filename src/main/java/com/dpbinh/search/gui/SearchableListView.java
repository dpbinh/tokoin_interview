package com.dpbinh.search.gui;

import com.dpbinh.search.entity.OrganizationSearchEnum;
import com.dpbinh.search.entity.TicketSearchEnum;
import com.dpbinh.search.entity.UserSearchEnum;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SearchableListView implements View {

    @Override
    public ViewName getName() {
        return ViewName.SEARCHABLE_LIST;
    }

    @Override
    public void draw(ViewFactory viewFactory, Map<String, Object> params) throws Exception {

        System.out.println("------------------------------------");
        System.out.println("Search Users with");
        UserSearchEnum.getAvailable().forEach(System.out::println);

        System.out.println("------------------------------------");
        System.out.println("Search Tickets with");
        TicketSearchEnum.getAvailable().forEach(System.out::println);

        System.out.println("------------------------------------");
        System.out.println("Search Organizations with");
        OrganizationSearchEnum.getAvailable().forEach(System.out::println);

    }
}
