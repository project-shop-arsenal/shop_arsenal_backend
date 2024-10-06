package com.project.shop_arsenal_backend.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(nullable = false)
    private String name; // Tên của khách hàng

    @Column(nullable = false, unique = true)
    private String phoneNumber; // Số điện thoại của khách hàng

    @Column
    private String address; // Địa chỉ của khách hàng

    @Column(nullable = false, unique = true)
    private String email; // Địa chỉ email của khách hàng

    @OneToOne // Liên kết với User
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user; // Người dùng liên kết với khách hàng
}
