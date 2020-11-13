package mate.academy.boot.hellobootdemo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
    @Column(columnDefinition = "review_id")
    private Long reviewId;
    @Column(columnDefinition = "user_id")
    private String userId;
    @Column(columnDefinition = "product_id")
    private String productId;
    @Column(columnDefinition = "profile_name")
    private String profileName;
    @Column(columnDefinition = "helpfulness_numerator")
    private int helpfulnessNumerator;
    @Column(columnDefinition = "helpfulness_denominator")
    private int helpfulnessDenominator;
    private int score;
    private Long time;
    private String summary;
    private String text;
}
