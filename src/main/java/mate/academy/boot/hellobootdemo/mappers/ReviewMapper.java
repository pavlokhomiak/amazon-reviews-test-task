package mate.academy.boot.hellobootdemo.mappers;

import mate.academy.boot.hellobootdemo.models.Review;
import mate.academy.boot.hellobootdemo.models.ReviewDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public Review toReview(ReviewDto dto) {
        Review review = new Review();
        review.setReviewId(dto.getReviewId());
        review.setUserId(dto.getUserId());
        review.setProductId(dto.getProductId());
        review.setProfileName(dto.getProfileName());
        review.setHelpfulnessNumerator(dto.getHelpfulnessNumerator());
        review.setHelpfulnessDenominator(dto.getHelpfulnessDenominator());
        review.setScore(dto.getScore());
        review.setTime(dto.getTime());
        review.setSummary(dto.getSummary());
        review.setText(dto.getText());
        review.setUser();
        return review;
    }
}
