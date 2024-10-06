package com.project.shop_arsenal_backend.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "OrderDetails")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detailId; // ID chi tiết đơn hàng (khóa chính)

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order; // Liên kết với bảng Order (mỗi chi tiết thuộc một đơn hàng)

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product; // Liên kết với bảng Product (mỗi chi tiết liên quan đến một sản phẩm)

    @Column(nullable = false)
    private int quantity; // Số lượng sản phẩm trong đơn hàng
}
