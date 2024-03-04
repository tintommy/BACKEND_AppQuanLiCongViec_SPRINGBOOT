package org.example.quanlycongviec.repository;

import org.example.quanlycongviec.entity.CongViec;
import org.example.quanlycongviec.entity.CongViecNgay;
import org.example.quanlycongviec.entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CongViecRepository extends JpaRepository<CongViec, Integer> {
    List<CongViec> findByNguoiDung_MaNguoiDung(int maND);


}
