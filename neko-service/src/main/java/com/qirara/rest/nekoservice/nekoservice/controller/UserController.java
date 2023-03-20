package com.qirara.rest.nekoservice.nekoservice.controller;

import com.qirara.rest.nekoservice.nekoservice.payload.request.UserRequest;
import com.qirara.rest.nekoservice.nekoservice.payload.response.UserResponse;
import com.qirara.rest.nekoservice.nekoservice.payload.response.WebResponse;
import com.qirara.rest.nekoservice.nekoservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(path = "/api/qirara")
public class UserController {

    private final MessageSource messageSource;

    private final UserService userService;

    public UserController(MessageSource messageSource, UserService userService) {
        this.messageSource = messageSource;
        this.userService = userService;
    }

    @PostMapping(path = "/user")
    public ResponseEntity<WebResponse<EntityModel<UserResponse>>> save(@Valid @RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.save(userRequest);

        URI URI = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(userResponse.getId()).toUri();

        // hateoas
        Link link = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).get(userResponse.getId())).withRel("user-detail");

        EntityModel<UserResponse> entityModel = EntityModel.of(userResponse, link);
        WebResponse<EntityModel<UserResponse>> webResponse = new WebResponse<>(
                HttpStatus.CREATED.value(),
                HttpStatus.CREATED.getReasonPhrase(),
                entityModel
        );
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
    public ResponseEntity<WebResponse<List<EntityModel<UserResponse>>>> getAll() {

        List<UserResponse> userResponses = userService.getAll();

        // hateoas in list data
        List<EntityModel<UserResponse>> entityModels = new ArrayList<>();
        for (UserResponse userResponse : userResponses) {
            Link link = WebMvcLinkBuilder
                    .linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).get(userResponse.getId())).withRel("user-detail");

            EntityModel<UserResponse> userResponseEntityModel = EntityModel.of(userResponse, link);
            entityModels.add(userResponseEntityModel);
        }

        WebResponse<List<EntityModel<UserResponse>>> webResponse = new WebResponse<>(
                HttpStatus.OK.value(),
                HttpStatus.OK.getReasonPhrase(),
                entityModels
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

    @GetMapping(path = "/user/{name}/locale")
    public ResponseEntity<WebResponse<String>> hello(@PathVariable String name) {
        Locale locale = LocaleContextHolder.getLocale();
        WebResponse<String> webResponse = new WebResponse<>(
                HttpStatus.OK.value(),
                HttpStatus.OK.getReasonPhrase(),
                messageSource.getMessage("good.morning.message", new Object[]{name}, locale)
        );

        return ResponseEntity.ok().body(webResponse);

    }

}
