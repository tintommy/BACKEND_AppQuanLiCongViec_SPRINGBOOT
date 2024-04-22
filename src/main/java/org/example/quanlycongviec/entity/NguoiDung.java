package org.example.quanlycongviec.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "nguoi_dung")
@Getter
@Setter
public class NguoiDung {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nd")
    private int maNguoiDung;

    private String ho;
    private String ten;

    @Column(name = "ngay_sinh")
    private String ngaySinh;

    @Column(name = "gioi_tinh")
    private boolean gioiTinh;
    @Column(name = "email")
    private String email;

    @Column(name = "mat_khau")
    private String matKhau;

    @Column(name = "ma_pin")
    private String maPin;

    @JsonIgnore
    @OneToMany(mappedBy = "nguoiDung",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<GhiChuMatKhau> ghiChuMatKhauList;

    @JsonIgnore
    @OneToMany(mappedBy = "nguoiDung",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<CongViec> congViecList;

    @JsonIgnore
    @OneToMany(mappedBy = "nguoiDung",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<SuKien> suKienList;

}
