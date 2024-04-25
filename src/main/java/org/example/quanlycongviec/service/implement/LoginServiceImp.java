package org.example.quanlycongviec.service.implement;


import jakarta.mail.MessagingException;
import org.example.quanlycongviec.Request.ChangePassRequest;
import org.example.quanlycongviec.Request.SignUpRequest;
import org.example.quanlycongviec.entity.ConsentOtpRedis;
import org.example.quanlycongviec.entity.NguoiDung;
import org.example.quanlycongviec.repository.ConsentOtpRedisRepository;
import org.example.quanlycongviec.repository.NguoiDungRepository;
import org.example.quanlycongviec.security.JwtTokenProvider;
import org.example.quanlycongviec.service.EmailService;
import org.example.quanlycongviec.service.LoginService;
import org.example.quanlycongviec.util.EmailUtil;
import org.example.quanlycongviec.util.OtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    EmailService emailService;
    @Autowired
    private NguoiDungRepository nguoiDungRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private OtpUtil otpUtil;
    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    ConsentOtpRedisRepository consentOtpRedisRepository;


    @Override
    public boolean addUser(SignUpRequest signUpRequest) {
        NguoiDung nguoiDung = new NguoiDung();
        NguoiDung nguoiDungByEmail = nguoiDungRepository.findByEmail(signUpRequest.getEmail());
        if (nguoiDungByEmail != null) return false;


        nguoiDung.setEmail(signUpRequest.getEmail());
        nguoiDung.setHo(signUpRequest.getHo());
        nguoiDung.setTen(signUpRequest.getTen());
        nguoiDung.setGioiTinh(signUpRequest.isGioiTinh());
        nguoiDung.setNgaySinh(signUpRequest.getNgaySinh());
        String passwordEncode = passwordEncoder.encode(signUpRequest.getPassword());

        nguoiDung.setMatKhau(passwordEncode);

        System.out.println(nguoiDung.toString());
        try {
            nguoiDungRepository.save(nguoiDung);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
//    @Override
//    public Boolean addUserCustomer(SignUpRequest signUpRequest) {
//        Movie_User account = new Movie_User();
//        RoleDTO role = roleService.getById(signUpRequest.getRoleId());
//        Optional<Movie_User> movieUser= movieUserRepository.findById(signUpRequest.getUsername());
//        if (movieUser.isPresent()) return false;
//        Optional<Movie_User> movieUseByEmail= movieUserRepository.findByEmail(signUpRequest.getEmail());
//        if (movieUseByEmail.isPresent()) return false;
////        Optional<Movie_User> movieUserByEmail= movieUserRepository.findById(signUpRequest.getEmail());
//
//        if (role == null ) return false;
//        String otp = otpUtil.generateOtp();
//        ConsentOtpRedis consentOtpRedis = new ConsentOtpRedis(signUpRequest.getUsername(),signUpRequest.getEmail(),signUpRequest.getPassword(),otp);
//
//        System.out.println("consentOtpRedis" + consentOtpRedis);
//        try {
//            String deleteAccounts = consentOtpRedisRepository.deleteAllAccountRedis(signUpRequest.getEmail());
//            consentOtpRedisRepository.save(consentOtpRedis);
//            emailUtil.sendOtpEmail(signUpRequest.getEmail(), otp,null, String.valueOf(signUpRequest.getRoleId()));
//        } catch (MessagingException e) {
//            throw new RuntimeException("Unable to send otp please try again");
//        }
////        if (movieUser.isPresent() && !movieUser.get().getActive())
////        {
////            account.setUsername(movieUser.get().getUsername());
////            account.setEmail(signUpRequest.getEmail());
////            account.setOtp(otp);
////            account.setOtpGeneratedTime(LocalDateTime.now());
////            account.setPassword(passwordEncode);
////
////        }
////        account.setRole(RoleMapper.INSTANCE.roleDtoToRole(role));
//////        account.setAvatar(signUpRequest.get);
////        account.setUsername(signUpRequest.getUsername());
////        account.setEmail(signUpRequest.getEmail());
////        String passwordEncode = passwordEncoder.encode(signUpRequest.getPassword());
////
////        account.setPassword(passwordEncode);
//
////        System.out.println(account.toString());
////        try {
////            movieUserRepository.save(account);
////            return true;
////        } catch (Exception ex) {
////            System.out.println(ex.getMessage());
////            return false;
////        }
//        return  true;
//    }

    @Override
    public boolean checkLogin(String email, String password) {
        NguoiDung nguoiDung = nguoiDungRepository.findByEmail(email);
        if (nguoiDung == null) return false;
        return passwordEncoder.matches(password, nguoiDung.getMatKhau());
    }


    @Override
    public String login(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                email, password
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        return token;
    }

    //    public Boolean changePassByOldPass (ChangePassRequest changePassRequest) {
//        System.out.println(changePassRequest);
//        NguoiDung nguoiDung = nguoiDungRepository.findByEmail(changePassRequest.getEmail());
//        if (nguoiDung==null) return false;
//        if (!passwordEncoder.matches(changePassRequest.getPassword(), nguoiDung.getMatKhau())) return false;
//        String newPasswordEncode = passwordEncoder.encode(changePassRequest.getNewPassword());
//       nguoiDung.setMatKhau(newPasswordEncode);
//        nguoiDungRepository.save(nguoiDung);
//        return true;
//    }
//    public Boolean changePassByOTP (ChangePassRequest changePassRequest) {
//        Optional<Movie_User> account = movieUserRepository.findById(changePassRequest.getUsername());
//        if (account.isEmpty()) return false;
//        if (!Objects.equals(changePassRequest.getEmail(), account.get().getEmail())) return false;
//        String otp = otpUtil.generateOtp();
//        try {
//            ConsentOtpRedis consentOtpRedis = new ConsentOtpRedis(changePassRequest.getUsername(),changePassRequest.getEmail(),changePassRequest.getPassword(),otp);
//            consentOtpRedisRepository.save(consentOtpRedis);
////            account.get().setOtp(otp);
////            account.get().setOtpGeneratedTime(LocalDateTime.now());
////            movieUserRepository.save(account.get());
//            emailUtil.sendOtpEmail(changePassRequest.getEmail(), otp, changePassRequest.getNewPassword(), changePassRequest.getRoleId());
//        } catch (MessagingException e) {
//            throw new RuntimeException("Unable to send otp please try again");
//        }
//
//
////        String passwordEncode = passwordEncoder.encode(changePassRequest.getPassword());
////        if (passwordEncode !=account.get().getPassword()) return false;
////        String newPasswordEncode = passwordEncoder.encode(changePassRequest.getNewPassword());
////        account.get().setPassword(newPasswordEncode);
////        movieUserRepository.save(account.get());
//        return true;
//    }
    public String regenerateOtp(String username, String email, String password, String roleId) {
        NguoiDung user = nguoiDungRepository.findByEmail(email);
//        String deleteAccountsRedis = consentOtpRedisRepository.deleteAllAccountRedis(email);
        String otp = otpUtil.generateOtp();
        ConsentOtpRedis consentOtpRedis = new ConsentOtpRedis(username, email, password, otp);
        try {
            emailUtil.sendOtpEmail(email, otp, null, roleId);
            consentOtpRedisRepository.save(consentOtpRedis);
        } catch (MessagingException e) {
            throw new RuntimeException("Unable to send otp please try again");
        }
        consentOtpRedisRepository.save(consentOtpRedis);
        return "Email sent... please verify account within 2 minute";
    }


    public String verifyAccount(String email, String otp, String newPass, String roleId) {
        ConsentOtpRedis consentOtpRedis = consentOtpRedisRepository.findConsentOtpRedisById(otp, email);
//        System.out.println(consentOtpRedis + "99999999999999999999999999999999999");
        if (consentOtpRedis == null) return "Please regenerate otp and try again";
        NguoiDung user = nguoiDungRepository.findByEmail(email);
        if (!newPass.isEmpty()) {
            if (user == null || !Objects.equals(user.getEmail(), consentOtpRedis.getEmail()))
                return "Email is not match";
        } else if (user != null) return "Email is used";
        NguoiDung account = new NguoiDung();
        account.setEmail(consentOtpRedis.getEmail());
        if (consentOtpRedis.getPassword() != null)
            account.setMatKhau(passwordEncoder.encode(consentOtpRedis.getPassword()));
        if (!newPass.isEmpty()) account.setMatKhau(passwordEncoder.encode(newPass));
        if (roleId == null) return "Role not found";
        if (consentOtpRedis.getOtp().equals(otp)) {

            nguoiDungRepository.save(account);
            return "OTP verified you can login";
        }
        return "Please regenerate otp and try again";
    }
}
