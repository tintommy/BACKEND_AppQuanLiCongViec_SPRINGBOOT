package org.example.quanlycongviec.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.quanlycongviec.entity.CongViecNgay;
import org.example.quanlycongviec.entity.HinhAnh;
import org.example.quanlycongviec.service.HinhAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/HinhAnh")
public class HinhAnhController {
    @Autowired
    private HinhAnhService hinhAnhService;


    @GetMapping("/LayHinhAnh/{maCvNgay}")
    private ResponseEntity<List<HinhAnh>> layHinhAnhCuaCongViecNgay(@PathVariable int maCvNgay) {
        List<HinhAnh> hinhAnhList = hinhAnhService.layTatCaHinhAnhCuaCongViecNgay(maCvNgay);
        if (!hinhAnhList.isEmpty())
            return ResponseEntity.ok(hinhAnhList);
        else
            return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/LuuHinhAnh", method = RequestMethod.POST)
    private ResponseEntity luuDanhSachAnh(@Validated @RequestBody List<Object> hinhAnhList) {



        for (int i = 0; i < hinhAnhList.size(); i++) {

            try {
                System.out.println(hinhAnhList.get(i).toString());
//                // Khởi tạo ObjectMapper để chuyển đổi JSON thành đối tượng Java
//                ObjectMapper objectMapper = new ObjectMapper();
//
//                // Chuyển đổi JSON thành đối tượng HinhAnh
//                HinhAnh hinhAnh = objectMapper.readValue(hinhAnhList.get(i).toString(), HinhAnh.class);
//                hinhAnhService.save(hinhAnh);

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
