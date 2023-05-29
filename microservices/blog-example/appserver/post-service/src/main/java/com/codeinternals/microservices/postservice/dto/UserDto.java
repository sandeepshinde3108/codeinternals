package com.codeinternals.microservices.postservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public final class UserDto {
    private long id;
    private String username;
    private String emailId;

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
