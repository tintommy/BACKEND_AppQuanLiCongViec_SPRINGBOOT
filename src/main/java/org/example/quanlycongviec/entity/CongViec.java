package org.example.quanlycongviec.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cong_viec")
public class CongViec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_cv")
    private Integer maCV;

    @Column(name = "tieu_de")
    private String tieuDe;

    @Column(name = "noi_dung")
    private String noiDung;

    @Column(name = "ngay_bat_dau")
    private Date ngayBatDau;

    @Column(name = "tinh_chat")
    private Integer tinhChat;

    @Column(name = "chu_ki")
    private String chuKi;

    @Column(name = "dung_sau_ngay")
    private Date dungSauNgay ;

    @Column(name = "so_lan")
    private Integer soLan;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "ma_nd")
    private NguoiDung nguoiDung;

    @OneToMany(mappedBy = "congViec",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<CongViecNgay> congViecNgayList;


}
