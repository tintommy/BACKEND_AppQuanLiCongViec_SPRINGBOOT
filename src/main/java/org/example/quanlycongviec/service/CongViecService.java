package org.example.quanlycongviec.service;

import org.example.quanlycongviec.entity.CongViec;
import org.example.quanlycongviec.entity.CongViecNgay;
import org.example.quanlycongviec.response.NgayDaTaoResponse;

import java.util.List;

public interface CongViecService {
    CongViec save(CongViec congViec);
    List<NgayDaTaoResponse> danhSachNgay(int maNd);

    long deleteCongViecTrongNgay(String ngaLam);

    List<CongViecNgay> layTatCaCongViecTheoNgay(int maNd, String ngay);

    int deleteCongViecNgayById(int id);

    CongViecNgay saveCongViecNgay(CongViecNgay congViecNgay);
}
