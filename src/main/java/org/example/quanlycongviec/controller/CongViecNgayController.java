package org.example.quanlycongviec.controller;

import org.example.quanlycongviec.entity.CongViecNgay;
import org.example.quanlycongviec.service.CongViecNgayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/CongViecNgay")
//http://localhost:8080/api/CongViecNgay
public class CongViecNgayController {
    private CongViecNgayService congViecNgayService;

    @Autowired
    public void setCongViecNgayService(CongViecNgayService congViecNgayService) {
        this.congViecNgayService = congViecNgayService;
    }

    @GetMapping("/NguoiDung/{maNd}/{ngay}")
    public ResponseEntity<List<CongViecNgay>> congViecNgayTheoMaNd(@PathVariable int maNd, @PathVariable String ngay) {
        List<CongViecNgay> listCongViecNgay = congViecNgayService.layTatCaCongViecNgayCuaNguoiDung(maNd, ngay);
        if (!listCongViecNgay.isEmpty()) {
            return ResponseEntity.ok(listCongViecNgay);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/NguoiDung/DtD/{maNd}/{ngayBatDau}/{ngayKetThuc}")
    public ResponseEntity<List<CongViecNgay>> layCongViecNgayTheoTuNgayToiNgay(@PathVariable int maNd, @PathVariable String ngayBatDau,@PathVariable String ngayKetThuc) {
        List<CongViecNgay> listCongViecNgay = congViecNgayService.layTatCaCongViecTuNgayDenNgay(maNd, ngayBatDau,ngayKetThuc);
        if (!listCongViecNgay.isEmpty()) {
            return ResponseEntity.ok(listCongViecNgay);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/NguoiDung/{maNd}/{thang}/{nam}")
    public ResponseEntity<List<CongViecNgay>> congViecNgayTheoMaNdVaThangNam(@PathVariable int maNd, @PathVariable int thang,@PathVariable int nam) {
        List<CongViecNgay> listCongViecNgay = congViecNgayService.layTatCaCongViecNgayCuaNguoiDungTheoThangNam(maNd, thang,nam);
        if (!listCongViecNgay.isEmpty()) {
            return ResponseEntity.ok(listCongViecNgay);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{maCvNgay}")
    public ResponseEntity<CongViecNgay> congViecNgayTheoMaCvNgay(@PathVariable int maCvNgay) {
        CongViecNgay congViecNgay = congViecNgayService.layCongViecNgayTheoMaCvNgay(maCvNgay);
        if (congViecNgay != null)
            return ResponseEntity.ok(congViecNgay);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/CapNhatTrangThai/{maCvNgay}/{maNd}/{ngay}")
    public ResponseEntity<List<CongViecNgay>> capNhatTrangThaiCongViecNgay(@PathVariable int maCvNgay,@PathVariable int maNd, @PathVariable String ngay) {
        CongViecNgay congViecNgay = congViecNgayService.layCongViecNgayTheoMaCvNgay(maCvNgay);
        congViecNgay.setTrangThai(!congViecNgay.isTrangThai());
        congViecNgayService.save(congViecNgay);
        List<CongViecNgay> listCongViecNgay = congViecNgayService.layTatCaCongViecNgayCuaNguoiDung(maNd, ngay);
        return ResponseEntity.ok(listCongViecNgay);
    }
    @PutMapping("/CapNhatCongViecNgay/{maCv}")
    public ResponseEntity<?> capNhatCongViecNgay(@RequestBody CongViecNgay cvNgay, @PathVariable int maCv) {
        CongViecNgay congViecNgay = congViecNgayService.capNhatCvNgay(cvNgay,maCv);
        if (congViecNgay != null)
            return ResponseEntity.ok(Collections.singletonMap("status", true));

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/XoaCongViecNgay/{maCvNgay}/{maNd}/{ngay}")
    public ResponseEntity<List<CongViecNgay>> xoaCongViecNgay(@PathVariable int maCvNgay,@PathVariable int maNd, @PathVariable String ngay){
        congViecNgayService.deleteById(maCvNgay);
        List<CongViecNgay> listCongViecNgay = congViecNgayService.layTatCaCongViecNgayCuaNguoiDung(maNd, ngay);
        if (!listCongViecNgay.isEmpty()) {
            return ResponseEntity.ok(listCongViecNgay);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/LuuCongViecNgay")
    public void luuCongViecNgay(@RequestBody CongViecNgay cvn )
    {
        congViecNgayService.save(cvn);
    }
}
