package org.example.quanlycongviec.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cong_viec_ngay")
@Getter
@Setter
public class CongViecNgay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_cv_ngay")
    private int maCvNgay;

    @Column(name = "ngay_lam")
    private String ngayLam;

    @Column(name = "trang_thai")
    private boolean trangThai;


    @Column(name = "phan_tram_hoan_thanh")
    private int phanTramHoanThanh;

    @JsonIgnore
    @OneToMany(mappedBy = "cvNgay",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<HinhAnh> hinhAnhList;

    @ManyToOne
    @JoinColumn(name = "ma_cv")
    private CongViec congViec;

}
