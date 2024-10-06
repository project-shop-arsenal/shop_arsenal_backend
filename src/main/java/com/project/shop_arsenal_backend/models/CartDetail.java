package com.project.shop_arsenal_backend.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Cart_Details")
public class CartDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detailId; // ID của chi tiết giỏ hàng

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart; // Giỏ hàng mà chi tiết này thuộc về

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product; // Sản phẩm trong giỏ hàng

    @Column(nullable = false)
    private Integer quantity; // Số lượng sản phẩm
}
