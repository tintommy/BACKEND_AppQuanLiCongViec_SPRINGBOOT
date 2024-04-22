package org.example.quanlycongviec.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CongViecRequest {
    private int maCV;
    private String tieuDe;
    private String noiDung;
    private String ngayBatDau;
    private int tinhChat;
    private String chuKi;
    private String dungSauNgay ;
    private int maNd;
}
