package com.samoylik.ViCall.user;

import lombok.Data;
import lombok.Builder;


@Data
@Builder
public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private String status;
}
