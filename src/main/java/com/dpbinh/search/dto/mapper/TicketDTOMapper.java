package com.dpbinh.search.dto.mapper;

import com.dpbinh.search.dto.TicketDTO;
import com.dpbinh.search.entity.Ticket;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketDTOMapper {
    TicketDTO toDTO(Ticket entity);

    List<TicketDTO> toDTOs(List<Ticket> entities);
}
