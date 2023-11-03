package vn.ladystudio.servicef.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vn.ladystudio.servicef.config.EnumRequestResult;
import vn.ladystudio.servicef.config.EnumUserRole;
import vn.ladystudio.servicef.exception.AuthException;
import vn.ladystudio.servicef.exception.ErrorCode;
import vn.ladystudio.servicef.model.UserEntity;
import vn.ladystudio.servicef.repository.SessionRepository;
import vn.ladystudio.servicef.repository.UserRepository;
import vn.ladystudio.servicef.request.LoginRequest;
import vn.ladystudio.servicef.request.RegisterRequest;
import vn.ladystudio.servicef.response.LoginResponse;
import vn.ladystudio.servicef.response.ResultResponse;
import vn.ladystudio.servicef.service.AuthService;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepo;

    private final SessionRepository sessionRepo;

    public AuthServiceImpl(UserRepository userRepo, SessionRepository sessionRepo) {
        this.userRepo = userRepo;
        this.sessionRepo = sessionRepo;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            log.info("Start login user {}", loginRequest.getUsr());

            LoginResponse loginResponse = new LoginResponse();

            validateInput(loginRequest.getUsr(), loginRequest.getPwd().toCharArray());

            UserEntity user = validateCredentials(loginRequest.getUsr(), loginRequest.getPwd().toCharArray());

            loginResponse.setAccessToken("abc.xyz.jqk");
            loginResponse.setTokenType("Bearer");
            loginResponse.setExpiresIn(3600);

            return loginResponse;
        } catch (AuthException a) {
            log.error("Login failed: {}", a.getMessage());
            throw a;
        } catch (Exception e) {
            log.error("Login failed: {}", e.getMessage());
            throw new AuthException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResultResponse logout() {
        return null;
    }

    @Override
    public ResultResponse register(RegisterRequest registerRequest) {
        try {
            log.info("Start registering user {}", registerRequest.getUsername());

            if (registerRequest.getUsername().isEmpty()
                    || registerRequest.getPassword().isEmpty()
                    || registerRequest.getEmail().isEmpty()) {
                log.error("Username, password or email is empty");
                return new ResultResponse(EnumRequestResult.FAILED,
                        "Not enough information");
            }

            UserEntity newUser = new UserEntity();

            if (userRepo.findByUsername(registerRequest.getUsername()).isPresent()) {
                log.error("User {} is already existed", registerRequest.getUsername());
                return new ResultResponse(EnumRequestResult.FAILED,
                        "User with this username is already existed");
            }

            newUser.setEmail(registerRequest.getEmail());
            newUser.setUsername(registerRequest.getUsername());
            newUser.setRole(EnumUserRole.USER.getValue());
            newUser.setCreatedAt(new Date());

            BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
            String password = pwdEncoder.encode(registerRequest.getPassword());

            newUser.setPassword(password);

            userRepo.save(newUser);
            log.info("Register successfully");

            return new ResultResponse(EnumRequestResult.SUCCESS,
                    "Register successfully");
        } catch (AuthException a) {
            log.error("Register failed: {}", a.getMessage());
            throw a;
        } catch (Exception e) {
            log.error("Register failed: {}", e.getMessage());
            throw new AuthException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    private void validateInput(String username, char[] password) {
        if (username.isEmpty() || password.length == 0) {
            throw new AuthException(ErrorCode.CREDENTIALS_INVALID);
        }
    }

    private UserEntity validateCredentials(String username, char[] password) {
        try {
            Optional<UserEntity> user = userRepo.findByUsername(username);

            if (user.isEmpty()) {
                throw new AuthException(ErrorCode.CREDENTIALS_WRONG);
            }

            BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
            if (!pwdEncoder.matches(new String(password), user.get().getPassword())) {
                throw new AuthException(ErrorCode.CREDENTIALS_WRONG);
            }
            Arrays.fill(password, '0');

            return user.get();
        } catch (AuthException a) {
            log.error("-- AuthException when validateCredentials in AuthServiceImpl: {}", a.toString());
            throw a;
        } catch (Exception e) {
            log.error("-- Exception when validateCredentials in AuthServiceImpl: {}", e.toString());
            throw new AuthException(ErrorCode.INTERNAL_SERVER_ERROR);
        }

    }
}
