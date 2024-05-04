package org.example.quanlycongviec.controller;

import org.example.quanlycongviec.entity.CongViecNgay;
import org.example.quanlycongviec.entity.SuKien;
import org.example.quanlycongviec.service.CongViecNgayService;
import org.example.quanlycongviec.service.SuKienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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

    @GetMapping("/TatCaSuKien/{maNd}")
    public ResponseEntity<List<SuKien>> tatCaSuKien( @PathVariable int maNd) {
        List<SuKien> listSuKien = suKienService.layTatCaSuKienCuaNguoiDung( maNd);

        if (!listSuKien.isEmpty()) {
            return ResponseEntity.ok(listSuKien);
        }
        return ResponseEntity.notFound().build();
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

    @PostMapping("/ThemSuKien")
    private ResponseEntity<?> themSuKien(@RequestBody SuKien suKien, @RequestParam Integer maNd) {
        SuKien sk = suKienService.add(suKien, maNd);
        if (sk != null)
            return ResponseEntity.ok(sk);

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/SuaSuKien")
    private ResponseEntity<?> suaSuKien(@RequestBody SuKien suKien, @RequestParam Integer maNd) {
        SuKien sk = suKienService.update(suKien, maNd);
        if (sk != null)
            return ResponseEntity.ok(Collections.singletonMap("status", true));

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/XoaSuKien")
    private ResponseEntity<?> xoaSuKien(@RequestParam Integer maSuKien) {
        suKienService.delete(maSuKien);
        return ResponseEntity.ok(Collections.singletonMap("status", true));


    }
    @GetMapping("SuKienTuNgayDenNgay/{ngayBD}/{ngayKT}/{maNd}")
    private ResponseEntity<?> suKienTuNgayDenNgay(@PathVariable String ngayBD, @PathVariable String ngayKT, @PathVariable Integer maNd){
        List<SuKien> EventstList = suKienService.laySuKienTuNgayDenNgayCuaNguoiDung(maNd, ngayBD, ngayKT);
        if (!EventstList.isEmpty()) {
            return ResponseEntity.ok(EventstList);
        }
        return ResponseEntity.notFound().build();
    }

}
