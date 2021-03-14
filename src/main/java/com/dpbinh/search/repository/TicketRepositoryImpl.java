package com.dpbinh.search.repository;

import com.dpbinh.search.config.AppSetting;
import com.dpbinh.search.domain.Ticket;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TicketRepositoryImpl extends BaseRepositoryImpl<Ticket> {

    public TicketRepositoryImpl(AppSetting appSetting) throws IOException {
        super(appSetting.getTicketFilePath());
    }
}
