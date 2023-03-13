package com.qirara.rest.nekoservice.nekoservice.service;

import com.qirara.rest.nekoservice.nekoservice.payload.request.UserRequest;
import com.qirara.rest.nekoservice.nekoservice.payload.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse save(UserRequest userRequest);
    UserResponse get(String id);
    List<UserResponse> getAll();
    void delete(String id);
}
