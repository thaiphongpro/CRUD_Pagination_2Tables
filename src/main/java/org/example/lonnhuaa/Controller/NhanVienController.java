package org.example.lonnhuaa.Controller;

import java.util.List;

import jakarta.validation.Valid;
import org.example.lonnhuaa.Entity.NhanVien;
import org.example.lonnhuaa.Model.Request.NhanVienRequest;
import org.example.lonnhuaa.Model.Response.NhanVienResponse;
import org.example.lonnhuaa.Repository.NhanVienRepository;
import org.example.lonnhuaa.Service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nhan-vien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping
    public List<NhanVienResponse> getNhanVien() {
        return nhanVienService.findAll();
    }

    @PostMapping("add")
    public void addNhanVien(@Valid @RequestBody NhanVienRequest request) {
        nhanVienService.addNhanVien(request);
    }

    @GetMapping("detail")
    public NhanVienResponse detailNhanVien(@Valid @RequestParam("id") Long id) {
        return nhanVienService.detailNhanVien(id);
    }

    @PutMapping("edit")
    public void editNhanVien(@Valid @RequestParam("id") Long id, @RequestBody NhanVienRequest request) {
        nhanVienService.editNhanVien(id, request);
    }

    @DeleteMapping("remove")
    public void removeNhanVien(@Valid @RequestParam("id") Long id) {
        nhanVienService.xoaNhanVien(id);
    }

    @GetMapping("paging")
    public List<NhanVienResponse> phanTrang(@RequestParam("pageNo") Integer pageNo,
                                            @RequestParam("pageSize") Integer pageSize) {
        return nhanVienService.phanTrang(pageNo, pageSize).getContent();
    }
}
