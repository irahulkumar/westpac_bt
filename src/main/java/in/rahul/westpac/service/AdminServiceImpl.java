package in.rahul.westpac.service;

import in.rahul.westpac.entity.Post;
import in.rahul.westpac.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final RestTemplate restTemplate;

    @Override
    public User getUserDetails(Integer id) {
        User user = null;

        String userResourceUrl = "https://jsonplaceholder.typicode.com/users/" + id;
        String userPostsResourceUrl = "https://jsonplaceholder.typicode.com/posts?userId=" + id;

        ResponseEntity userResponseEntity = restTemplate.getForEntity(userResourceUrl, User.class);
        ResponseEntity postsResponseEntity = restTemplate.getForEntity(userPostsResourceUrl, List.class);

        if(userResponseEntity.getStatusCode() == HttpStatus.OK && postsResponseEntity.getStatusCode() == HttpStatus.OK){
            user = (User) userResponseEntity.getBody();
            List<Post> posts = (List<Post>) postsResponseEntity.getBody();
            user.setPosts(posts);
        }

        return user;
    }
}
