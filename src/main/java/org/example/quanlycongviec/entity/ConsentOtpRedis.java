package org.example.quanlycongviec.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("ConsentOtpRedis")
public class ConsentOtpRedis implements Serializable {
    private String username;
    private String email;
    private String password;
    @Id
    private String otp;
//    private LocalDateTime timestamp;

}