package org.example.quanlycongviec.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    private String email;
    private String password;
    private String ho;
    private String ten;
    private String ngaySinh;
    private boolean gioiTinh;

}
