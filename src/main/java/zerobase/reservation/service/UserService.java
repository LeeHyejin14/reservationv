package zerobase.reservation.service;

import org.springframework.stereotype.Service;
import zerobase.reservation.domain.User;
import zerobase.reservation.dto.UserRequest;
import zerobase.reservation.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 사용자 등록
    public User registerUser(UserRequest userRequest) {
        User user = new User(userRequest.getId());
        return userRepository.save(user);
    }

    // 사용자 조회
    public User checkUser(String id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }
}