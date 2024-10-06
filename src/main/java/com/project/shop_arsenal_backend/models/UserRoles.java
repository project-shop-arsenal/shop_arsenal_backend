package com.project.shop_arsenal_backend.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "UserRoles")
public class UserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Người dùng

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;  // Vai trò
}
