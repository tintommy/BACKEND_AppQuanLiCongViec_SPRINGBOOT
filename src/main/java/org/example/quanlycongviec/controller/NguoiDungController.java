package org.example.quanlycongviec.controller;

import org.example.quanlycongviec.entity.NguoiDung;
import org.example.quanlycongviec.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/NguoiDung")
public class NguoiDungController {
    private NguoiDungService nguoiDungService;

    @Autowired
    public void setNguoiDungService(NguoiDungService nguoiDungService) {
        this.nguoiDungService = nguoiDungService;
    }


    @GetMapping("/{email}")
    public ResponseEntity<NguoiDung> getNguoiDung(@PathVariable String email){
        NguoiDung nguoiDung = nguoiDungService.findUserByEmail(email);
        System.out.println(email);
        if(nguoiDung!=null)
            return ResponseEntity.ok(nguoiDung);
        else
            return ResponseEntity.notFound().build();
    }

}
