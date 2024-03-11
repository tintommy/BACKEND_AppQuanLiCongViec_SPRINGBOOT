package org.example.quanlycongviec.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.quanlycongviec.entity.CongViecNgay;
import org.example.quanlycongviec.entity.HinhAnh;
import org.example.quanlycongviec.service.CongViecNgayService;
import org.example.quanlycongviec.service.HinhAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/HinhAnh")
public class HinhAnhController {
    @Autowired
    private HinhAnhService hinhAnhService;
    @Autowired
    private CongViecNgayService congViecNgayService;


    @GetMapping("/LayHinhAnh/{maCvNgay}")
    private ResponseEntity<List<HinhAnh>> layHinhAnhCuaCongViecNgay(@PathVariable int maCvNgay) {
        List<HinhAnh> hinhAnhList = hinhAnhService.layTatCaHinhAnhCuaCongViecNgay(maCvNgay);
        if (!hinhAnhList.isEmpty())
            return ResponseEntity.ok(hinhAnhList);
        else
            return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/LuuHinhAnh/{maCvNgay}", method = RequestMethod.POST)
    private ResponseEntity<Void> luuDanhSachAnh(@PathVariable int maCvNgay, @Validated @RequestBody List<String > anhUrlList) {

        CongViecNgay congViecNgay = congViecNgayService.layCongViecNgayTheoMaCvNgay(maCvNgay);

        for (int i = 0; i < anhUrlList.size(); i++) {
            try {
                hinhAnhService.save(new HinhAnh(anhUrlList.get(i),congViecNgay));

            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.internalServerError().build();
            }
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/XoaHinhAnh/{maHinhAnh}")
    private ResponseEntity xoaHinhAnh(@PathVariable int maHinhAnh) {
        hinhAnhService.xoaHinhAnhTheoMa(maHinhAnh);
        return ResponseEntity.ok().build();
    }
}
