package org.example.quanlycongviec.controller;

import org.example.quanlycongviec.entity.CongViecNgay;
import org.example.quanlycongviec.service.CongViecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/CongViec")
public class CongViecController {
    @Autowired
    CongViecService congViecService;
    @GetMapping("")
        //http://localhost:8080/api/CongViec
    ResponseEntity<List<CongViecNgay>> layTatCaCongViecNgayCuaNguoiDung() {
        return ResponseEntity.ok(congViecService.layTatCaCongViecNgayCuaNguoiDung(2));
    }
}
