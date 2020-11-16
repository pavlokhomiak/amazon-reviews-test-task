package mate.academy.boot.hellobootdemo.service;

import java.util.List;
import mate.academy.boot.hellobootdemo.models.Review;

public interface ReviewService {
    void add(Review review);

    List<Review> getAll();

    Review getById(Long id);

    void delete(Long id);
}
