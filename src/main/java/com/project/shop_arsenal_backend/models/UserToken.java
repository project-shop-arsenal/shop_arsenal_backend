package com.project.shop_arsenal_backend.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "UserTokens")
public class UserToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Người dùng sở hữu mã thông báo

    @ManyToOne
    @JoinColumn(name = "type_token_id", nullable = false)
    private TypeTokens typeToken; // Loại mã thông báo

    @Column(nullable = false, unique = true, length = 255)
    private String token; // Mã thông báo

    @Column(nullable = false)
    private LocalDateTime createdAt; // Thời gian tạo mã thông báo

    @Column(nullable = false)
    private LocalDateTime expiresAt; // Thời gian hết hạn mã thông báo

    // Constructors, Getters and Setters if needed (Lombok @Data đã tạo sẵn)
}
