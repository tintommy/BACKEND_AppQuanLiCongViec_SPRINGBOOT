package org.example.quanlycongviec.repository;

import org.example.quanlycongviec.entity.CongViecNgay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CongViecNgayRepository extends JpaRepository<CongViecNgay, Integer> {
    List<CongViecNgay> findCongViecNgayByCongViec_NguoiDung_MaNguoiDung(int maNd);
}
