package org.example.lonnhuaa.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien {
    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 20)
    @Column(name = "Ma", length = 20)
    private String ma;

    @Size(max = 30)
    @Nationalized
    @ColumnDefault("NULL")
    @Column(name = "Ten", length = 30)
    private String ten;

    @Size(max = 30)
    @Nationalized
    @ColumnDefault("NULL")
    @Column(name = "TenDem", length = 30)
    private String tenDem;

    @Size(max = 30)
    @Nationalized
    @ColumnDefault("NULL")
    @Column(name = "Ho", length = 30)
    private String ho;

    @Size(max = 10)
    @Nationalized
    @ColumnDefault("NULL")
    @Column(name = "GioiTinh", length = 10)
    private String gioiTinh;

    @ColumnDefault("NULL")
    @Column(name = "NgaySinh")
    private LocalDate ngaySinh;

    @Size(max = 100)
    @Nationalized
    @ColumnDefault("NULL")
    @Column(name = "DiaChi", length = 100)
    private String diaChi;

    @Size(max = 30)
    @ColumnDefault("NULL")
    @Column(name = "Sdt", length = 30)
    private String sdt;

    @ColumnDefault("NULL")
    @Lob
    @Column(name = "MatKhau")
    private String matKhau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCV")
    private ChucVu idCV;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdGuiBC")
    private NhanVien idGuiBC;

    @ColumnDefault("0")
    @Column(name = "TrangThai")
    private Integer trangThai;

}