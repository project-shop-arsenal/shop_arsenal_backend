package com.project.shop_arsenal_backend.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "full_name", nullable = false)
    private String fullName; // Tên đầy đủ của nhân viên

    @ManyToOne // Mối quan hệ nhiều - một với bảng Position
    @JoinColumn(name = "position_id", nullable = false)
    private Position position; // Chức vụ của nhân viên

    @Column(name = "address")
    private String address; // Địa chỉ của nhân viên

    @Column(name = "tel", length = 20)
    private String tel; // Số điện thoại của nhân viên

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private Date birthday; // Ngày sinh của nhân viên

    @Column(nullable = false, unique = true)
    private String email; // Địa chỉ email của nhân viên

    @Column(name = "salary", nullable = false, precision = 10, scale = 2)
    private BigDecimal salary; // Mức lương của nhân viên

    @Column(name = "image_url")
    private String imageUrl; // URL của hình ảnh nhân viên

    @OneToOne // Liên kết với User
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user; // Người dùng liên kết với nhân viên
}
