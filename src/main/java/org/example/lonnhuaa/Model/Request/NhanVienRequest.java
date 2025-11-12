package org.example.lonnhuaa.Model.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVienRequest {
    @NotBlank(message = "maNv can not blank")
    private String maNv;

    @NotBlank(message = "tennv can not blank")
    private String tenNv;

    @NotBlank(message = "gioiTinh can not blank")
    private String gioiTinh;

    @NotBlank(message = "ID Chuc Vu can not blank")
    private Long idCV;
}
