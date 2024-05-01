package org.example.quanlycongviec.service;

import org.example.quanlycongviec.entity.CongViecNgay;

import java.util.List;

public interface CongViecNgayService {
    List<CongViecNgay> layTatCaCongViecNgayCuaNguoiDung(int maNguoiDung,String ngay);
    CongViecNgay save(CongViecNgay congViecNgay);
    void  deleteById(int maCvNgay);
    CongViecNgay layCongViecNgayTheoMaCvNgay(int maCvNgay);

    List<CongViecNgay> layTatCaCongViecNgayCuaNguoiDungTheoThangNam(int maNd, int thang, int nam);

    CongViecNgay capNhatCvNgay(CongViecNgay congViecNgay, int maCv);
    
    List<CongViecNgay>layTatCaCongViecTuNgayDenNgay(int maNd, String ngayBatDau, String ngayKetThuc);
}
