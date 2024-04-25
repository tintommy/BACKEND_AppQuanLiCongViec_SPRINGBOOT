package org.example.quanlycongviec.repository;

import org.example.quanlycongviec.entity.GhiChuCaNhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GhiChuCaNhanRepository extends JpaRepository<GhiChuCaNhan, Integer> {
    @Query(value = "select gccn.* from Ghi_Chu_Ca_Nhan gccn inner join Nguoi_Dung nd on gccn.ma_nd = nd.ma_nd where nd.ma_nd= :maNd",nativeQuery = true)
    List<GhiChuCaNhan> timDanhSachGhiChuTheoMaNguoiDung(int maNd);


}
