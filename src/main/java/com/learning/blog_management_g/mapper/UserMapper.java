package com.learning.blog_management_g.mapper;

import com.learning.blog_management_g.entity.User;
import com.learning.blog_management_g.entity_dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toUserDTO(User user);
}
