package com.example.assignment.domain.dto.request;

import com.example.assignment.domain.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest implements Serializable {
    @JsonProperty("user_name")
    private String username;
//    @JsonProperty("status")
//    private UserStatus status;
}
