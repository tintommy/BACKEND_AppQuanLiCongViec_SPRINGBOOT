package org.example.quanlycongviec.repository;

import org.example.quanlycongviec.entity.CongViecNgay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CongViecNgayRepository extends JpaRepository<CongViecNgay, Integer> {
    List<CongViecNgay> findByCongViec_NguoiDung_MaNguoiDungAndNgayLam(int maNd, String ngayLam);
    CongViecNgay findByMaCvNgay(int maCvNgay);

    List<CongViecNgay> findCongViecNgayByCongViec_NguoiDung_MaNguoiDung(int maNd);
    int countByNgayLamAndTrangThaiAndCongViec_NguoiDung_MaNguoiDung(String ngaylam,boolean trangThai, int maNd);

}
