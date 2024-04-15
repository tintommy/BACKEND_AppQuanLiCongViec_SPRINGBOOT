package org.example.quanlycongviec.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInRequest {
//    private String username="";
    private String email="";
    private String password="";
}
