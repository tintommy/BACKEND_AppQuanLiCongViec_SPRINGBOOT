package org.example.quanlycongviec.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cong_viec")
@Getter
@Setter
public class CongViec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_cv")
    private int maCV;

    @Column(name = "tieu_de")
    private String tieuDe;

    @Column(name = "noi_dung")
    private String noiDung;

    @Column(name = "ngay_bat_dau")
    private String ngayBatDau;

    @Column(name = "tinh_chat")
    private int tinhChat;

    @Column(name = "chu_ki")
    private String chuKi;

    @Column(name = "dung_sau_ngay")
    private String dungSauNgay ;

    @Column(name = "so_lan")
    private int soLan;


    @ManyToOne()
    @JoinColumn(name = "ma_nd")
    @JsonIgnore
    private NguoiDung nguoiDung;

    @JsonIgnore
    @OneToMany(mappedBy = "congViec",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<CongViecNgay> congViecNgayList;


}
