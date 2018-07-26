package com.in28minutes.rest.webservices.restfulwebservices.user.post;

import com.in28minutes.rest.webservices.restfulwebservices.user.NotFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.user.User;
import com.in28minutes.rest.webservices.restfulwebservices.user.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class PostResource {

    @Autowired
    private UserDaoService userDaoService;

    @Autowired
    private PostDAO postDAO;

    @GetMapping("/{userId}/posts")
    public List<Post> getPosts(@PathVariable int userId) {
        return postDAO.getByUser(userId);
    }

    @GetMapping("/{userId}/posts/{postId}")
    public Post getPosts(@PathVariable int userId, @PathVariable int postId) {
        Optional<Post> post = postDAO.get(postId);

        return post.filter(post1 -> post1.getUser().getId() == userId)
                .orElseThrow(() -> new NotFoundException("userId:" + userId + ":postId:" + postId));

    }


    @PostMapping("/{userId}/posts")
    public Post createPost(@PathVariable int userId, @RequestBody Post post) {

        User user = userDaoService.findOne(userId)
                .orElseThrow(() -> new NotFoundException("userId:" + userId));

        post.setUser(user);

        return postDAO.save(post);


    }


}
