package org.example.quanlycongviec.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NgayDaTaoResponse {
    private String ngay;
    private double phanTram;
    private int maNd;
}
