package org.example.quanlycongviec.service;

import org.example.quanlycongviec.entity.SuKien;

import java.util.Date;
import java.util.List;

public interface SuKienService {

    List<SuKien> timSuKienTheoNgayCuaNguoiDung(String ngay, int maNd);

    List<SuKien> timSuKienSapToiCuaNguoiDung(String ngay, int maNd);

    SuKien add(SuKien sk,int maNd);
    SuKien update(SuKien sk,int maNd);
    Void delete(int maSuKien);

    List<SuKien> layTatCaSuKienCuaNguoiDung(int maNd);
    List<SuKien> laySuKienTuNgayDenNgayCuaNguoiDung(int maNd, String ngayBD, String ngayKT);
}
