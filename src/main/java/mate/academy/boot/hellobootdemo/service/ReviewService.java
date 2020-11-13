package mate.academy.boot.hellobootdemo.service;

import mate.academy.boot.hellobootdemo.models.Review;

import java.util.List;

public interface ReviewService {
    void add(Review review);

    List<Review> getAll();

    Review getById(Long id);

    void delete(Long id);
}
