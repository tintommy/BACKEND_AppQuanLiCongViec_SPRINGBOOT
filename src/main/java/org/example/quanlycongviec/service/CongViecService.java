package org.example.quanlycongviec.service;

import org.example.quanlycongviec.entity.CongViecNgay;
import org.example.quanlycongviec.entity.NguoiDung;

import java.util.List;

public interface CongViecService {
 List<CongViecNgay> layTatCaCongViecNgayCuaNguoiDung(int maNguoiDung);
}
