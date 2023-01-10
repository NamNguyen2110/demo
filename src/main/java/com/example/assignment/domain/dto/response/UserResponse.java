package com.example.assignment.domain.dto.response;

import com.example.assignment.domain.dto.request.UserRequest;
import com.example.assignment.domain.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse extends UserRequest implements Serializable {
    @JsonProperty("id")
    private Integer id;
}
