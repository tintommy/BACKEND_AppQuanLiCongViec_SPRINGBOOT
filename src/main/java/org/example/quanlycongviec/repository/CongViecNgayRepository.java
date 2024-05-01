package org.example.quanlycongviec.repository;

import org.example.quanlycongviec.entity.CongViecNgay;
import org.example.quanlycongviec.entity.SuKien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface CongViecNgayRepository extends JpaRepository<CongViecNgay, Integer> {
    List<CongViecNgay> findByCongViec_NguoiDung_MaNguoiDungAndNgayLam(int maNd, String ngayLam);

    CongViecNgay findByMaCvNgay(int maCvNgay);


    List<CongViecNgay> findCongViecNgayByCongViec_NguoiDung_MaNguoiDung(int maNd);
    int countByNgayLamAndTrangThaiAndCongViec_NguoiDung_MaNguoiDung(String ngaylam,boolean trangThai, int maNd);

    long deleteByNgayLam(String ngayLam);
    int deleteByMaCvNgay(int id);

    @Query(value = "SELECT cvn.* FROM Cong_Viec_Ngay cvn inner join Cong_Viec cv on cvn.ma_cv= cv.ma_cv  WHERE MONTH(cvn.ngay_lam) = :thang AND YEAR(cvn.ngay_lam) = :nam And cv.ma_nd=:maNd", nativeQuery = true)
    List<CongViecNgay> getAllTaskOfUserByMonthYear(@Param("maNd") int maNd, @Param("thang") int thang,@Param("nam") int nam);

    List<CongViecNgay> findByCongViec_NguoiDung_MaNguoiDungAndNgayLamBetween(int maNd, String ngayBatDau, String ngayKetThuc);

}
