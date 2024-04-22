package org.example.quanlycongviec.service;

import org.example.quanlycongviec.entity.SuKien;

import java.util.Date;
import java.util.List;

public interface SuKienService {
    SuKien save(SuKien suKien);
    List<SuKien> timSuKienTheoNgayCuaNguoiDung(String ngay, int maNd);

    List<SuKien> timSuKienSapToiCuaNguoiDung(String ngay, int maNd);
}
