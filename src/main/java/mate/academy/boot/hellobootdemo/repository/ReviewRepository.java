package mate.academy.boot.hellobootdemo.repository;

import mate.academy.boot.hellobootdemo.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Override
    @Query("from Review r join fetch r.user where r.id = :id")
    Review getOne(@Param("id") Long id);
}
