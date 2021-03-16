package com.dpbinh.search.repository;

import com.dpbinh.search.config.AppSetting;
import com.dpbinh.search.entity.Ticket;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TicketRepositoryImpl extends BaseRepositoryImpl<Ticket> implements TicketRepository {

    public TicketRepositoryImpl(AppSetting appSetting) throws IOException {
        super(appSetting.getTicketFilePath(), new TypeReference<List<Ticket>>() {});
    }
}
