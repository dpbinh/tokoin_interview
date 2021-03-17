package com.dpbinh.search.dto.mapper;

import com.dpbinh.search.dto.UserDTO;
import com.dpbinh.search.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDTOMapper {

    UserDTO toDTO(User entity);

    List<UserDTO> toDTOs(List<User> entities);
}
