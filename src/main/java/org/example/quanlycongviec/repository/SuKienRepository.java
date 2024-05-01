package org.example.quanlycongviec.repository;

import org.example.quanlycongviec.entity.SuKien;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface SuKienRepository extends JpaRepository<SuKien, Integer> {

    List<SuKien> findByNgayAndNguoiDung_MaNguoiDung(String ngay,int maNd);

    @Query(value = "EXEC FindNearlyEvent @ngay = ?1,@maNd = ?2 ", nativeQuery = true)
    public List<SuKien> findNearlyEvent(String ngay, int maNd);

    @Query(value = "SELECT * FROM Su_Kien sk where sk.ma_nd=:maNd",nativeQuery = true)
    List<SuKien> getAllEventOfUser(@Param("maNd") int maNd);
    @Query(value = "SELECT * FROM Su_Kien sk where sk.ma_nd=:maNd and sk.ngay BETWEEN :ngayBD AND :ngayKT", nativeQuery = true)
    public List<SuKien> findEventsFromDayToDay(@Param("maNd") int maNd, @Param("ngayBD") String ngayBD, @Param("ngayKT") String ngayKT);


}
