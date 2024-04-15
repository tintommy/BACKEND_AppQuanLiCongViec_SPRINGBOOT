package org.example.quanlycongviec.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Hinh_Anh")
@Getter
@Setter
public class HinhAnh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hinh")
    private int maHinh;

    @Column(name = "link")
    private String link;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "ma_cv_ngay")
    private CongViecNgay cvNgay;

    public HinhAnh( String link,CongViecNgay cvNgay) {
        this.link = link;
        this.cvNgay = cvNgay;
    }

    @Override
    public String toString() {
        return "HinhAnh{" +
                "maHinh=" + maHinh +
                ", link='" + link + '\'' +
                ", cvNgay=" + cvNgay +
                '}';
    }
}
