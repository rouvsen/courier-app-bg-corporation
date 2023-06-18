package com.company.kotlinapp_apis.bean;

import com.company.kotlinapp_apis.dto.UserDto.UserDto;
import com.company.kotlinapp_apis.model.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    UserDto toDto(User user);
    User toEntity(UserDto userDto);

}
