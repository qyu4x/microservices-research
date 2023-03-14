package com.qirara.rest.nekoservice.nekoservice.controller;

import com.qirara.rest.nekoservice.nekoservice.payload.request.UserRequest;
import com.qirara.rest.nekoservice.nekoservice.payload.response.UserResponse;
import com.qirara.rest.nekoservice.nekoservice.payload.response.WebResponse;
import com.qirara.rest.nekoservice.nekoservice.repository.UserRepository;
import com.qirara.rest.nekoservice.nekoservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/qirara")
public class UserController {

   private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/user")
    public ResponseEntity<WebResponse<UserResponse>> save(@Valid @RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.save(userRequest);
        WebResponse<UserResponse> webResponse = new WebResponse<>(
                HttpStatus.CREATED.value(),
                HttpStatus.CREATED.getReasonPhrase(),
                userResponse
        );

        URI URI = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(userResponse.getId()).toUri();

        return ResponseEntity.created(URI).body(webResponse);

    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<WebResponse<UserResponse>> get(@PathVariable String id) {
        UserResponse userResponse = userService.get(id);
        WebResponse<UserResponse> webResponse = new WebResponse<>(
                HttpStatus.OK.value(),
                HttpStatus.OK.getReasonPhrase(),
                userResponse
        );

        return ResponseEntity.ok().body(webResponse);

    }

    @GetMapping(path = "/user")
    public ResponseEntity<WebResponse<List<UserResponse>>> getAll() {
        List<UserResponse> userResponse = userService.getAll();
        WebResponse<List<UserResponse>> webResponse = new WebResponse<>(
                HttpStatus.OK.value(),
                HttpStatus.OK.getReasonPhrase(),
                userResponse
        );

        return ResponseEntity.ok().body(webResponse);

    }

    @DeleteMapping(path = "/user/{id}")
    public ResponseEntity<WebResponse<String>> delete(@PathVariable String id) {
        userService.delete(id);
        WebResponse<String> webResponse = new WebResponse<>(
                HttpStatus.OK.value(),
                HttpStatus.OK.getReasonPhrase(),
                String.format("User id : %s , is deleted", id)
        );

        return ResponseEntity.ok().body(webResponse);

    }

}
