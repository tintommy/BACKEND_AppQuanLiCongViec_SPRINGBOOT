package org.example.quanlycongviec.service;


import org.example.quanlycongviec.Request.ChangePassRequest;
import org.example.quanlycongviec.Request.SignUpRequest;

public interface LoginService {
    boolean addUser(SignUpRequest signUpRequest);

    boolean checkLogin(String email, String password);

    String login( String email, String password);
    String regenerateOtp(String username, String email, String password,String roleId);
    String verifyAccount(String email, String otp, String newPass, String roleId);

//    Boolean changePassByOldPass(ChangePassRequest changePassRequest);
//    Boolean changePassByOTP(ChangePassRequest changePassRequest);
//    Boolean addUserCustomer(SignUpRequest signUpRequest);

}
