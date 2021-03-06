package com.dpbinh.search.repository;

import com.dpbinh.search.config.AppSetting;
import com.dpbinh.search.entity.User;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository {

    public UserRepositoryImpl(AppSetting appSetting) throws IOException {
        super(appSetting.getUserFilePath(), new TypeReference<List<User>>() {});
    }
}
