package org.example.quanlycongviec.repository;

import org.example.quanlycongviec.entity.CongViec;
import org.example.quanlycongviec.entity.HinhAnh;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HinhAnhRepository extends JpaRepository<HinhAnh,Integer> {
    List<HinhAnh> findByCvNgay_MaCvNgay(int maCvNgay);

}
