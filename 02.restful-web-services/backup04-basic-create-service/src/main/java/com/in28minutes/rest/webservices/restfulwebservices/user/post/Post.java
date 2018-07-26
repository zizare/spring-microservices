package com.in28minutes.rest.webservices.restfulwebservices.user.post;

import com.in28minutes.rest.webservices.restfulwebservices.user.User;
import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Post {
    private int id;
    private String message;
    private User user;
}
