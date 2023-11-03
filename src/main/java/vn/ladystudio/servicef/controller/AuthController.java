package vn.ladystudio.servicef.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.ladystudio.servicef.request.LoginRequest;
import vn.ladystudio.servicef.request.RegisterRequest;
import vn.ladystudio.servicef.response.LoginResponse;
import vn.ladystudio.servicef.response.ResultResponse;
import vn.ladystudio.servicef.service.AuthService;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final
    AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        log.info("loginRequest: " + loginRequest);
        LoginResponse loginResponse = authService.login(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }

//    @PostMapping("/logout")

//    @PostMapping("/refresh")

    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResultResponse> register(@Valid @RequestBody RegisterRequest registerRequest) {
        log.info("registerRequest: " + registerRequest);
        ResultResponse resultResponse = authService.register(registerRequest);
        return ResponseEntity.ok(resultResponse);
    }
//    @PostMapping("/forgot-password")

}
