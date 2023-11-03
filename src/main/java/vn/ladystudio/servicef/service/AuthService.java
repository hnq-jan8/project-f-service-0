package vn.ladystudio.servicef.service;

import vn.ladystudio.servicef.request.LoginRequest;
import vn.ladystudio.servicef.request.RegisterRequest;
import vn.ladystudio.servicef.response.LoginResponse;
import vn.ladystudio.servicef.response.ResultResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);

    ResultResponse logout();

    ResultResponse register(RegisterRequest registerRequest);

}
