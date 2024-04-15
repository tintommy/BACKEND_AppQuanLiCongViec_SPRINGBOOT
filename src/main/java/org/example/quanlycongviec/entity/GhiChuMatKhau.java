package org.example.quanlycongviec.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ghi_chu_mat_khau")
@Getter
@Setter
public class GhiChuMatKhau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_gcmk")
    private int maGhiChuMK;

    @Column(name = "tieu_de")
    private String tieuDe;

    @Column(name = "tai_khoan")
    private String taiKhoan;

    @Column(name = "mat_khau")
    private String matKhau;

    @Column(name = "ghi_chu_khac")
    private String ghiChuKhac;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "ma_nd")
    private NguoiDung nguoiDung;


}
