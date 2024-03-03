package org.example.quanlycongviec.service;

import org.example.quanlycongviec.entity.CongViecNgay;

import java.util.List;

public interface CongViecNgayService {
    List<CongViecNgay> layTatCaCongViecNgayCuaNguoiDung(int maNguoiDung);
}
