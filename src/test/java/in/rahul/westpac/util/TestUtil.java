package in.rahul.westpac.util;

import in.rahul.westpac.entity.*;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {


    public static User getUserWithPost() {
        User user = getUser();
        List<Post> posts = getposts();
        user.setPosts(posts);
        return user;
    }
    public static User getUser() {
        return User.builder()
                .id(1)
                .name("Leanne Graham")
                .username("Bret")
                .email("Sincere@april.biz")
                .address(Address.builder()
                        .street("Kulas Light")
                        .suite("Apt. 556")
                        .city("Gwenborough")
                        .zipcode("92998-3874")
                        .geo(Geo.builder()
                                .lat("- 37.3159")
                                .lng("81.1496")
                                .build())
                        .build())
                .phone("1-770-736-8031x56442")
                .website("hildegard.org")
                .company(Company.builder()
                        .name("Romaguera-Crona")
                        .catchPhrase("Multi-layered client-server neural-net")
                        .bs("harness real-time e-markets")
                        .build())
                .build();
    }

    public static List<Post> getposts() {
        List<Post> posts = new ArrayList<>();

        posts.add(Post.builder()
                .userId(1)
                .id(1)
                .title("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")
                .body("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto")
                .build());

        posts.add(Post.builder()
                .userId(1)
                .id(2)
                .title("qui est esse")
                .body("est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla")
                .build());

        posts.add(Post.builder()
                .userId(1)
                .id(3)
                .title("ea molestias quasi exercitationem repellat qui ipsa sit aut")
                .body("et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut")
                .build());

        posts.add(Post.builder()
                .userId(1)
                .id(4)
                .title("eum et est occaecati")
                .body("ullam et saepe reiciendis voluptatem adipisci\nsit amet autem assumenda provident rerum culpa\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\nquis sunt voluptatem rerum illo velit")
                .build());

        return posts;
    }
}
