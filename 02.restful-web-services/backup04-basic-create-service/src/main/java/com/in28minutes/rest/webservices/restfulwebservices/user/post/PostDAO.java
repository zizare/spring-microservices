package com.in28minutes.rest.webservices.restfulwebservices.user.post;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostDAO {

    private static List<Post> posts = new ArrayList<>();



    public Optional<Post> get(int id){
        return posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst();
    }

    public Post save(Post post){
        post.setId(posts.size()+1);
        posts.add(post);
        return post;
    }

    public List<Post> getByUser(int userID){
        return posts.stream().filter(post -> post.getUser().getId() == userID)
                .collect(Collectors.toList());
    }

}
