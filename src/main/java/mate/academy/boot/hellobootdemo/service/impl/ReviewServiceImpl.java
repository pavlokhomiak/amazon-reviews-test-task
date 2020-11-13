package mate.academy.boot.hellobootdemo.service.impl;

import mate.academy.boot.hellobootdemo.models.Review;
import mate.academy.boot.hellobootdemo.repository.ReviewRepository;
import mate.academy.boot.hellobootdemo.service.ReviewService;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void add(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getById(Long id) {
        return reviewRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }
}
