package org.example.quanlycongviec.controller;

import lombok.RequiredArgsConstructor;
import org.example.quanlycongviec.Request.CongViecRequest;
import org.example.quanlycongviec.entity.CongViec;
import org.example.quanlycongviec.entity.CongViecNgay;
import org.example.quanlycongviec.response.NgayDaTaoResponse;
import org.example.quanlycongviec.service.CongViecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.example.quanlycongviec.mapper.CongViecMapper;

import java.util.List;

@RestController
@RequestMapping(path = "/CongViec")
@RequiredArgsConstructor
public class CongViecController {

    private final CongViecService congViecService;
    private final CongViecMapper congviecMapper;



    @GetMapping("/quanlyngay/{maNd}")
    private ResponseEntity<List<NgayDaTaoResponse>> danhSachNgay(@PathVariable int maNd) {
        List<NgayDaTaoResponse> items = congViecService.danhSachNgay(maNd);
        if (!items.isEmpty()) {
            return ResponseEntity.ok(items);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/quanlyngay/{ngay}")
    private ResponseEntity<Long> danhSachNgay(@PathVariable String ngay) {
        long soViecDaXoa = congViecService.deleteCongViecTrongNgay(ngay);
        if (soViecDaXoa!=0) {
            return ResponseEntity.ok(soViecDaXoa);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/quanlyngay/{maNd}/{ngay}")
    public ResponseEntity<List<CongViecNgay>> congViecNgayTheoMaNd(@PathVariable int maNd, @PathVariable String ngay) {
        List<CongViecNgay> listCongViecNgay = congViecService.layTatCaCongViecTheoNgay(maNd, ngay);
        if (!listCongViecNgay.isEmpty()) {
            return ResponseEntity.ok(listCongViecNgay);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("")
    private ResponseEntity<?> saveCongViec(@RequestBody CongViecRequest congViecRequest) {
        CongViec congViec = congviecMapper.congViecDtoToCongViec(congViecRequest);
        if (congViecService.save(congViec) != null) {
            return ResponseEntity.ok(congViec);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/quanlyngay/id/{idCv}")
    private  ResponseEntity<?> xoaCongViecNgay(@PathVariable int idCv ) {
        int result = congViecService.deleteCongViecNgayById(idCv);
        if (result != 0) {
            return ResponseEntity.ok(1);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/congViecNgay")
    private ResponseEntity<?> saveCongViecNgay(@RequestBody CongViecNgay congViecNgay) {
        if (congViecService.saveCongViecNgay(congViecNgay) != null) {
            return ResponseEntity.ok(congViecNgay);
        }
        return ResponseEntity.badRequest().build();
    }





}
