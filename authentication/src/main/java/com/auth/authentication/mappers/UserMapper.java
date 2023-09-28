package com.auth.authentication.mappers;

import com.auth.authentication.dtos.UserDto;
import com.auth.authentication.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserDto, User> {
}
