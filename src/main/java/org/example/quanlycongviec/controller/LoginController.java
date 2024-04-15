package org.example.quanlycongviec.controller;


import org.example.quanlycongviec.Request.SignInRequest;
import org.example.quanlycongviec.Request.SignUpRequest;
import org.example.quanlycongviec.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/Login")
public class LoginController {

    @Autowired
    private LoginService loginService;




    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest) {
        if (loginService.addUser(signUpRequest)==false) {
            return new ResponseEntity<>(Collections.singletonMap("status", false), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(Collections.singletonMap("status", true), HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SignInRequest signInRequest) {
        String password = signInRequest.getPassword();
        String email = signInRequest.getEmail();
        String token="";
        if(loginService.checkLogin(email, password)) {
             token = loginService.login( email, password);

        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(Collections.singletonMap("token", token), HttpStatus.OK);
    }

    @GetMapping("/verify-account")
    public ResponseEntity<String> verifyAccount(@RequestParam String email,
                                                @RequestParam String otp,
                                                @RequestParam(defaultValue = "") String newPass,
                                                @RequestParam String roleId
    ) {
        return new ResponseEntity<>(loginService.verifyAccount(email, otp, newPass, roleId), HttpStatus.OK);
    }
    @PutMapping("/regenerate-otp")
    public ResponseEntity<String> regenerateOtp(@RequestParam String email,
                                                @RequestParam String username,
                                                @RequestParam String roleId,
                                                @RequestParam(defaultValue = "") String password) {
        return new ResponseEntity<>(loginService.regenerateOtp(username, email,password, roleId), HttpStatus.OK);
    }
//    @PutMapping("/change-pass-otp")
//    public ResponseEntity<String> regenerateOtp(@RequestBody ChangePassRequest changePassRequest) {
//        return new ResponseEntity<>(loginService.changePassByOTP(changePassRequest).toString(), HttpStatus.OK);
//    }

}
