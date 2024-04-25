package org.example.quanlycongviec.controller;

import org.example.quanlycongviec.entity.GhiChuCaNhan;
import org.example.quanlycongviec.service.GhiChuCaNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequestMapping(path = "/GhiChu")
@RestController
public class GhiChuCaNhanController {
    private GhiChuCaNhanService ghiChuCaNhanService;

    @Autowired
    public void setGhiChuCaNhanService(GhiChuCaNhanService ghiChuCaNhanService) {
        this.ghiChuCaNhanService = ghiChuCaNhanService;
    }

    @GetMapping("/LayDanhSachGhiChu/{maNd}")
    public ResponseEntity<?> layDanhSachGhiChu(@PathVariable int maNd) {
        List<GhiChuCaNhan> gccnList = ghiChuCaNhanService.timDanhSachGhiChuTheoMaNguoiDung(maNd);
        if (!gccnList.isEmpty()) {
            return ResponseEntity.ok(gccnList);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/LuuGhiChu/{email}")
    public ResponseEntity<GhiChuCaNhan> luuGhiChu(@PathVariable String email, @RequestBody GhiChuCaNhan gccn) {
        GhiChuCaNhan gccnTemp= ghiChuCaNhanService.taoHoacSuaGhiChu(gccn, email);

        if ( gccnTemp!= null) {
            return ResponseEntity.ok(gccnTemp);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/XoaGhiChu/{maGhiChu}")
    public ResponseEntity<?> xoaGhiChu(@PathVariable int maGhiChu) {
        ghiChuCaNhanService.xoaTheoMa(maGhiChu);
        return new ResponseEntity<>(Collections.singletonMap("status", true), HttpStatus.OK);
    }

}
