package zerobase.reservation.service;

import org.springframework.stereotype.Service;
import zerobase.reservation.domain.Review;
import zerobase.reservation.domain.Store;
import zerobase.reservation.domain.User;
import zerobase.reservation.dto.ReviewRequest;
import zerobase.reservation.repository.ReviewRepository;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final StoreService storeService;
    private final UserService userService;

    public ReviewService(ReviewRepository reviewRepository, StoreService storeService, UserService userService) {
        this.reviewRepository = reviewRepository;
        this.storeService = storeService;
        this.userService = userService;
    }

    // 리뷰 작성
    public Review writeReview(ReviewRequest reviewRequest) {
        Store store = storeService.checkStore(reviewRequest.getStoreName());
        User user = userService.checkUser(reviewRequest.getUserid());
        Review review = new Review(store, user, reviewRequest.getRating(), reviewRequest.getContent());

        return reviewRepository.save(review);
    }
}
