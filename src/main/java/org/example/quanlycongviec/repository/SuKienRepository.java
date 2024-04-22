package org.example.quanlycongviec.repository;

import org.example.quanlycongviec.entity.SuKien;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface SuKienRepository extends JpaRepository<SuKien, Integer> {

    List<SuKien> findByNgayAndNguoiDung_MaNguoiDung(String ngay,int maNd);

    @Query(value = "EXEC FindNearlyEvent @ngay = ?1,@maNd = ?2 ", nativeQuery = true)
    public List<SuKien> findNearlyEvent(String ngay, int maNd);

}
