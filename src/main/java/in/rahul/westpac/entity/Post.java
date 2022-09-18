package in.rahul.westpac.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
}
