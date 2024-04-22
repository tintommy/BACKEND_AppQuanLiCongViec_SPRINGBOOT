package org.example.quanlycongviec.controller;

import org.example.quanlycongviec.entity.CongViecNgay;
import org.example.quanlycongviec.service.CongViecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/CongViec")
public class CongViecController {

    private CongViecService congViecService;
    @Autowired
    public void setCongViecService(CongViecService congViecService) {
        this.congViecService = congViecService;
    }


    @GetMapping("/quanlyngay/{maNd}")
    private ResponseEntity<List<String>> danhSachNgay(@PathVariable int maNd) {
        List<String> items = congViecService.danhSachNgay(maNd);
        if (!items.isEmpty()) {
            return ResponseEntity.ok(items);
        }
        return ResponseEntity.notFound().build();
    }

//    @PostMapping("/save")
//    public ResponseEntity<List<String>> saveCongViec(@PathVariable int maNd) {
//        congViecService.save()
//        return ResponseEntity.notFound().build();
//    }


}
