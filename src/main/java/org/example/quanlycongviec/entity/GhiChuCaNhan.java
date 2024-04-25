package org.example.quanlycongviec.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ghi_chu_ca_nhan")
@Getter
@Setter
public class GhiChuCaNhan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_gccn")
    private int maGCCN;

    @Column(name = "tieu_de")
    private String tieuDe;

    @Column(name = "noi_dung")
    private String noiDung;

    @Column(name = "ngay_chinh_sua")
    private String ngayChinhSua;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "ma_nd")
    @JsonIgnore
    private NguoiDung nguoiDung;
}
