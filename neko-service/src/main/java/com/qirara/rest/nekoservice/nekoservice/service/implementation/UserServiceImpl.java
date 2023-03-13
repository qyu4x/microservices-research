package com.qirara.rest.nekoservice.nekoservice.service.implementation;

import com.qirara.rest.nekoservice.nekoservice.entity.User;
import com.qirara.rest.nekoservice.nekoservice.exception.DataNotFoundException;
import com.qirara.rest.nekoservice.nekoservice.payload.request.UserRequest;
import com.qirara.rest.nekoservice.nekoservice.payload.response.UserResponse;
import com.qirara.rest.nekoservice.nekoservice.repository.UserRepository;
import com.qirara.rest.nekoservice.nekoservice.service.UserService;
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.base64.Base64Encoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse save(UserRequest userRequest) {
        User user = new User(
                UUID.randomUUID().toString().replace("-", ""),
                userRequest.getName(),
                userRequest.getBirthDate(),
                OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.of("+07:00")).toLocalDateTime()
        );

        userRepository.save(user);

        return new UserResponse(
                Base64.getEncoder().encodeToString(user.getId().getBytes()),
                user.getName(),
                user.getBirthDate(),
                user.getCreatedAt()
        );
    }

    @Override
    public UserResponse get(String id) {
        User user = userRepository.findById(new String(Base64.getDecoder().decode(id)))
                .orElseThrow(() -> new DataNotFoundException("Opps, data not found"));
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getBirthDate(),
                user.getCreatedAt()
        );
    }

    @Override
    public List<UserResponse> getAll() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();
        users.stream().forEach(user -> {
            UserResponse userResponse = new UserResponse(
                    Base64.getEncoder().encodeToString(user.getId().getBytes()),
                    user.getName(),
                    user.getBirthDate(),
                    user.getCreatedAt()
            );
            userResponses.add(userResponse);
        });

        return userResponses;
    }

    @Override
    public void delete(String id) {
        userRepository.findById(new String(Base64.getDecoder().decode(id)))
                .orElseThrow(() -> new DataNotFoundException("Opps, data not found"));
        userRepository.deleteById(id);
    }
}
