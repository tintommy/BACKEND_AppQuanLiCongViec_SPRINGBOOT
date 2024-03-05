package org.example.quanlycongviec.controller;

import lombok.AllArgsConstructor;
import org.example.quanlycongviec.entity.CongViecNgay;
import org.example.quanlycongviec.service.CongViecNgayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/CongViecNgay")
@AllArgsConstructor
public class CongViecNgayController {
    private CongViecNgayService congViecNgayService;

    @GetMapping("/{maNd}")
    public ResponseEntity<List<CongViecNgay>> congViecNgayTheoMaNd(@PathVariable int maNd ) {
        List<CongViecNgay> listCongViecNgay = congViecNgayService.layTatCaCongViecNgayCuaNguoiDung(maNd);
        if (!listCongViecNgay.isEmpty()) {
            return ResponseEntity.ok(listCongViecNgay);
        }
        return ResponseEntity.notFound().build();
    }

}
