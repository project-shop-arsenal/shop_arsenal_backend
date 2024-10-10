package com.project.shop_arsenal_backend.models;

import com.project.shop_arsenal_backend.models.enums.UserType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true, nullable = false)
    private String username; // Tên đăng nhập của người dùng

    @Column(nullable = false)
    private String password; // Mật khẩu của người dùng

    @Column(name = "is_verified", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isVerified; // Trạng thái xác thực của người dùng

    @Column(name = "verification_token")
    private String verificationToken; // Token xác thực email

    @Column(name = "password_expiry_date")
    private LocalDate passwordExpiryDate; // Ngày hết hạn mật khẩu

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserRoles> userRoles; // Danh sách vai trò của người dùng

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Customer customer; // Thông tin khách hàng liên kết

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Employee employee; // Thông tin nhân viên liên kết

    @Enumerated(EnumType.STRING) // Chỉ định kiểu enum lưu dưới dạng chuỗi
    @Column(name = "user_type", nullable = false)
    private UserType userType; // Loại người dùng (CUSTOMER hoặc EMPLOYEE)
}
