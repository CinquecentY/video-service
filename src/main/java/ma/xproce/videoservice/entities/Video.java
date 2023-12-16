package ma.xproce.videoservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
    private String description;
    private Date datePublication;

    @ManyToOne
    private Creator creator;
}

























/*
@Controller
public class graphql{
@Autowired
private userrepository userrepo;

@Querymapping
public list<User> getByemail(@Argument String email){
    return usrrrepo.getByemail(email);
    }

   mutation mapping
}
 */