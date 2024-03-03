package org.example.quanlycongviec.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "nguoi_dung")
public class NguoiDung {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nd")
    private Integer maNguoiDung;

    private String ho;
    private String ten;

    @Column(name = "ngay_sinh")
    private String ngaySinh;

    @Column(name = "gioi_tinh")
    private String gioiTinh;

    private String email;

    @Column(name = "mat_khau")
    private String matKhau;

    @Column(name = "ma_pin")
    private String maPin;

    @OneToMany(mappedBy = "nguoidung",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<GhiChuMatKhau> ghiChuMatKhauList;


    @OneToMany(mappedBy = "nguoidung",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<CongViec> congViecList;

    @OneToMany(mappedBy = "nguoidung",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<SuKien> suKienList;

}
