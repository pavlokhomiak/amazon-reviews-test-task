package mate.academy.boot.hellobootdemo.mappers;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import mate.academy.boot.hellobootdemo.models.Review;
import mate.academy.boot.hellobootdemo.models.ReviewDto;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReviewMapperTest {
    private static final ReviewMapper mapper = new ReviewMapper();
    private static Review expectedReview = new Review();
    private ReviewDto normalDto = new ReviewDto(Long.parseLong("38"), "B001EO5QW8", "A3MGP2E1ZZ6GRB",
            "\"Zardoz \"\"focuspuller\"\"\"", Integer.parseInt("1"), Integer.parseInt("1"),
            Integer.parseInt("5"), Long.parseLong("1238457600"), "it's oatmeal",
            "\"What else do you need to know? Oatmeal, instant (make it with a half cup of low-fat milk and add raisins\tnuke"
                    + " for 90 seconds). More expensive than something. It's still just oatmeal. Mmm, convenient!\"");
    private ReviewDto reviewWithNullField = new ReviewDto(Long.parseLong("38"), "B001EO5QW8", "A3MGP2E1ZZ6GRB",
            "\"Zardoz \"\"focuspuller\"\"\"", Integer.parseInt("1"), Integer.parseInt("1"),
            Integer.parseInt("5"), null, "it's oatmeal",
            "\"What else do you need to know? Oatmeal, instant (make it with a half cup of low-fat milk and add raisins\tnuke"
                    + " for 90 seconds). More expensive than something. It's still just oatmeal. Mmm, convenient!\"");

    @BeforeClass
    public static void inject() {
        expectedReview.setReviewId(38L);
        expectedReview.setProductId("B001EO5QW8");
        expectedReview.setUserId("A3MGP2E1ZZ6GRB");
        expectedReview.setProfileName("\"Zardoz \"\"focuspuller\"\"\"");
        expectedReview.setHelpfulnessNumerator(1);
        expectedReview.setHelpfulnessDenominator(1);
        expectedReview.setScore(5);
        expectedReview.setTime(LocalDateTime.ofEpochSecond(1238457600L, 0, ZoneOffset.UTC));
        expectedReview.setSummary("it's oatmeal");
        expectedReview.setText("\"What else do you need to know? Oatmeal, instant (make it with a half cup of low-fat milk and add raisins\tnuke"
                + " for 90 seconds). More expensive than something. It's still just oatmeal. Mmm, convenient!\"");
    }

    @Test
    public void shouldExecute_OK() {
        Review actualReview = mapper.toReview(normalDto);

        Assert.assertEquals(expectedReview, actualReview);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionWithTimeNull() {
        mapper.toReview(reviewWithNullField);
    }
}
