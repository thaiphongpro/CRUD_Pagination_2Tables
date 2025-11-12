package org.example.lonnhuaa.Model.Response;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.example.lonnhuaa.Entity.NhanVien;

@Getter
@Setter
public class NhanVienResponse {
    /**
     * Hiển thị: gồm các trường:
     * Mã nhân viên,
     * Tên nhân viên,
     * Giới tính,
     * Tuổi,
     * Tên chức vụ
     */
    private Long id;

    @NotBlank(message = "maNv can not blank")
    private String maNv;

    @NotBlank(message = "tennv can not blank")
    private String tenNv;

    @NotBlank(message = "gioiTinh can not blank")
    private String gioiTinh;

    @NotBlank(message = "tenChucVu can not blank")
    private String tenChucVu;

    public NhanVienResponse(NhanVien nhanVien) {
        this.id = nhanVien.getId();
        this.maNv = nhanVien.getMa();
        this.tenNv = nhanVien.getTen();
        this.gioiTinh = nhanVien.getGioiTinh();
        if (nhanVien.getIdCV() != null) {
            this.tenChucVu = nhanVien.getIdCV().getTen();
        }
    }
}
