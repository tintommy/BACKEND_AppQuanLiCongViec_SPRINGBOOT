package org.example.quanlycongviec.controller;

import org.example.quanlycongviec.entity.CongViecNgay;
import org.example.quanlycongviec.entity.SuKien;
import org.example.quanlycongviec.service.CongViecNgayService;
import org.example.quanlycongviec.service.SuKienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/SuKien")
public class SuKienController {
    private SuKienService suKienService;

    @Autowired
    public void setSuKienService(SuKienService suKienService) {
        this.suKienService = suKienService;
    }
    @GetMapping("/SuKienHomNay/{ngay}/{maNd}")
    public ResponseEntity<List<SuKien>> suKienHomNay(@PathVariable String ngay, @PathVariable int maNd) {
        List<SuKien> listSuKien = suKienService.timSuKienTheoNgayCuaNguoiDung(ngay, maNd);
        if (!listSuKien.isEmpty()) {
            return ResponseEntity.ok(listSuKien);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/SuKienSapToi/{ngay}/{maNd}")
    public ResponseEntity<List<SuKien>> suKienSapToi(@PathVariable String ngay, @PathVariable int maNd) {
        List<SuKien> listSuKien = suKienService.timSuKienSapToiCuaNguoiDung(ngay, maNd);

        if (!listSuKien.isEmpty()) {
            return ResponseEntity.ok(listSuKien);
        }
        return ResponseEntity.notFound().build();
    }
}
