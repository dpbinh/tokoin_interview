package com.dpbinh.search.service;

import com.dpbinh.search.dto.TicketDTO;

import java.util.List;

public interface TicketService {
    List<TicketDTO> search(String property, String value);
}
