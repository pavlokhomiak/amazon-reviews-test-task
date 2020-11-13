package mate.academy.boot.hellobootdemo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;
import lombok.Data;

@Data
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "id")
    private Long id;
    @Column(columnDefinition = "user_id")
    private String userId;
    @Column(columnDefinition = "profile_name")
    private String profileName;
    @Column(columnDefinition = "password")
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Review> reviewList;
    @ManyToMany
    @JoinColumn(name = "id")
    private List<Role> roles;
}
