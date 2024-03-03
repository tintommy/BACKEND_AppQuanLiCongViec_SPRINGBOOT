package org.example.quanlycongviec.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cong_viec_ngay")
public class CongViecNgay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_cv_ngay")
    private int maCvNgay;

    @Column(name = "ngay_lam")
    private Date ngayLam;

    @Column(name = "trang_thai")
    private boolean trangThai;

    @Column(name = "hinh_anh")
    private String hinhAnh;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "ma_cv")
    private CongViec congViec;





}
