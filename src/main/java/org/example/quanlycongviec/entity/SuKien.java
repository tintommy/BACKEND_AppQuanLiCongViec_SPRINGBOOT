package org.example.quanlycongviec.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "su_kien")
public class SuKien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_sk")
    private int maSK;

    @Column(name = "ten_su_kien")
    private String tenSuKien;
    private String ngay;
    private String gio;

    @Column(name = "nhac_truoc")
    private int nhacTruoc;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name="ngay_nhac")
    private String ngayNhac;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "ma_nd")
    private NguoiDung nguoiDung;

}
