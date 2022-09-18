package in.rahul.westpac.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Geo {
    private String lat;
    private String lng;
}
