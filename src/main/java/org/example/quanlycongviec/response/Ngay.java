package org.example.quanlycongviec.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.quanlycongviec.entity.CongViecNgay;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ngay {
    private String ngay;
    private double phanTram;
    private int maNd;
    private List<CongViecNgayResponse> danhSachCongViecNgay;
}
