package com.vchdev.security.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtResponse {
    private String token;
    private String username;
    private String role;

    public JwtResponse(String accessToken, String username, String role) {
        this.token = accessToken;
        this.username = username;
        this.role = role;
    }
}
