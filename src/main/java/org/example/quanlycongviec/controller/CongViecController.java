package org.example.quanlycongviec.controller;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class CongViecController {

    private CongViecService congViecService;

}
