package org.example.quanlycongviec.controller;

import org.example.quanlycongviec.entity.NguoiDung;
import org.example.quanlycongviec.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


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

    @PostMapping("/LuuMaPin/{email}/{pin}")
    public ResponseEntity<?> luuPin(@PathVariable String email,@PathVariable String pin){
        NguoiDung nguoiDung = nguoiDungService.saveMaPin(email,pin);
        System.out.println(email);
        if(nguoiDung!=null)
            return new ResponseEntity<>(Collections.singletonMap("status", true), HttpStatus.OK);
        else
            return new ResponseEntity<>(Collections.singletonMap("status", false), HttpStatus.NOT_FOUND);
    }
    @PostMapping("/KiemTraMaPin/{email}/{pin}")
    public ResponseEntity<?> kiemTraPin(@PathVariable String email,@PathVariable String pin){

        if(nguoiDungService.checkMaPin(email,pin))
            return new ResponseEntity<>(Collections.singletonMap("status", true), HttpStatus.OK);
        else
            return new ResponseEntity<>(Collections.singletonMap("status", false), HttpStatus.NOT_FOUND);
    }
    @PostMapping("/DoiMaPin/{email}/{matKhau}/{pin}")
    public ResponseEntity<?> kiemTraPin(@PathVariable String email,@PathVariable String matKhau,@PathVariable String pin){

        if(nguoiDungService.DoiMaPin(email,matKhau,pin))
            return new ResponseEntity<>(Collections.singletonMap("status", true), HttpStatus.OK);
        else
            return new ResponseEntity<>(Collections.singletonMap("status", false), HttpStatus.NOT_FOUND);
    }
}
