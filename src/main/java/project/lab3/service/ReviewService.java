package project.lab3.service;

import project.lab3.models.Review;
import project.lab3.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository repository;
    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }
    public void addReview(String author, String text, int gameId) {
        repository.save(author, text, gameId);
    }
    public void deleteReview(int id) {
        repository.delete(id);
    }
    public List<Review> getAllReviews() {
        return repository.findAll();
    }
}