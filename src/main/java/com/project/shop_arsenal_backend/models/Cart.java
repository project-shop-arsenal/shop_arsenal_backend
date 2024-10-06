package com.project.shop_arsenal_backend.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "Carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId; // ID của giỏ hàng

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Người sở hữu giỏ hàng

    @Column(nullable = false)
    private LocalDateTime createdDate; // Ngày tạo giỏ hàng

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<CartDetail> cartDetails; // Danh sách các mục chi tiết trong giỏ hàng
}
