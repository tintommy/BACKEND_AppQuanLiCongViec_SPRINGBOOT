package org.example.quanlycongviec.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "su_kien")
@Getter
@Setter
public class SuKien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_sk")
    private int maSK;

    @Column(name = "ten_su_kien")
    private String tenSuKien;
    @Column(name = "ngay")
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
    @JsonIgnore
    private NguoiDung nguoiDung;

}
