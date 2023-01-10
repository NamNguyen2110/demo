package com.example.assignment.domain.mapper;

import com.example.assignment.domain.dto.request.UserRequest;
import com.example.assignment.domain.entity.Users;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    Users toEntity(UserRequest request);
    UserRequest toDto(Users request);
}
