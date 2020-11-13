package mate.academy.boot.hellobootdemo.mappers;

import mate.academy.boot.hellobootdemo.models.ReviewDto;
import mate.academy.boot.hellobootdemo.models.User;

public class UserMapper {
    public User toUser(ReviewDto reviewDto) {
        User user = new User();
        user.setReviewList();
    }
}
