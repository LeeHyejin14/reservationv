package zerobase.reservation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zerobase.reservation.dto.ReviewRequest;
import zerobase.reservation.service.ReviewService;

@RestController
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // 리뷰 작성
    @PostMapping("/review")
    public ResponseEntity<String> writeReview(@RequestParam("orderNumber") Long orderNumber,
                                              @Validated @RequestBody ReviewRequest reviewRequest) {
        reviewService.writeReview(reviewRequest);
        return new ResponseEntity<>("리뷰 작성 완료", HttpStatus.CREATED);
    }
}