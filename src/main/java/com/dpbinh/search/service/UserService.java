package com.dpbinh.search.service;

import com.dpbinh.search.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> search(String property, String value);
}
