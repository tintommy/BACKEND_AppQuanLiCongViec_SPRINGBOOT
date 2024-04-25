package org.example.quanlycongviec.service.implement;

import jakarta.mail.internet.MimeMessage;
import org.example.quanlycongviec.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String fromEmail;
    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public String sendMail(String to) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(fromEmail);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject("Xác thực tài khoản");
            String otp = generateOtp();
            mimeMessageHelper.setText("""
                    <div>
                       <h3>App Quản Lí Công Việc</h3>
                       <h1> OTP: %s  </h1>
                      <br/>
                          
                    </div>
                    """.formatted(otp), true);
            javaMailSender.send(mimeMessage);

            return otp;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String generateOtp() {
        Random random = new Random();
        int randomNumber = random.nextInt(999999);
        String output = Integer.toString(randomNumber);

        while (output.length() < 6) {
            output = "0" + output;
        }
        return output;
    }
}
