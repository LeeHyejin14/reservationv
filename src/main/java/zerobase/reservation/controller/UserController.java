package zerobase.reservation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import zerobase.reservation.domain.User;
import zerobase.reservation.dto.UserRequest;
import zerobase.reservation.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 사용자 등록
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Validated @RequestBody UserRequest userRequest) {
        User user = userService.registerUser(userRequest);
        if (user != null) {
            return ResponseEntity.ok("회원 가입 완료");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원 가입 실패");
        }
    }

    // 사용자 조회
    @GetMapping("/{id}")
    public ResponseEntity<User> checkUser(@PathVariable String id) {
        User user = userService.checkUser(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}