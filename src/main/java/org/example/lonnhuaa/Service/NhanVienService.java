package org.example.lonnhuaa.Service;

import java.util.List;

import org.example.lonnhuaa.Entity.ChucVu;
import org.example.lonnhuaa.Entity.NhanVien;
import org.example.lonnhuaa.Model.Request.NhanVienRequest;
import org.example.lonnhuaa.Model.Response.NhanVienResponse;
import org.example.lonnhuaa.Repository.ChucVuRepository;
import org.example.lonnhuaa.Repository.NhanVienRepository;
import org.example.lonnhuaa.Util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private ChucVuRepository chucVuRepository;

    public List<NhanVienResponse> findAll() {
        return nhanVienRepository.findAll()
                .stream()
                .map(NhanVienResponse::new)
                .toList();
    }


    public void addNhanVien(NhanVienRequest request) {
        NhanVien nhanVien = MapperUtil.map(request, NhanVien.class);
        nhanVien.setMa(request.getMaNv());
        if (request.getMaNv().equalsIgnoreCase(nhanVien.getMa())) {
            throw new RuntimeException("Can not duplicate Ma: " + request.getMaNv());
        }
        nhanVien.setTen(request.getTenNv());
        if (request.getIdCV() != null) {
            ChucVu chucVu = chucVuRepository.findById(request.getIdCV()).orElseThrow(
                    () -> new RuntimeException("chucVu not found")
                                                                                    );
            nhanVien.setIdCV(chucVu);
        }
        nhanVienRepository.save(nhanVien);
    }

    public NhanVienResponse detailNhanVien(Long id) {
        NhanVien nhanVien = nhanVienRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can not find NhanVien ID: " + id)
                                                                       );
        return new NhanVienResponse(nhanVien);
    }

    public void editNhanVien(Long id, NhanVienRequest request) {
        NhanVien nhanVien = nhanVienRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can not find NhanVien ID: " + id)
                                                                       );
        nhanVien.setMa(request.getMaNv());
        if (request.getMaNv().equalsIgnoreCase(nhanVien.getMa())) {
            throw new RuntimeException("Can not duplicate Ma: " + request.getMaNv());
        }
        nhanVien.setTen(request.getTenNv());
        MapperUtil.mapToExisting(request, nhanVien);
        if (request.getIdCV() != null) {
            ChucVu chucVu = chucVuRepository.findById(request.getIdCV()).orElseThrow(
                    () -> new RuntimeException("chucVu not found")
                                                                                    );
            nhanVien.setIdCV(chucVu);
        }
        nhanVienRepository.save(nhanVien);
    }

    public void xoaNhanVien(Long id) {
        nhanVienRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can not find NhanVien ID: " + id)
                                                   );
        nhanVienRepository.deleteById(id);
    }

    public Page<NhanVienResponse> phanTrang(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<NhanVien> pageProduct = nhanVienRepository.findAll(pageable);
        Page<NhanVienResponse> pageResponse = pageProduct.map(NhanVienResponse::new);
        return pageResponse;
    }
}
