package com.project.shop_arsenal_backend.models;

import com.project.shop_arsenal_backend.models.enums.Size;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId; // ID của sản phẩm

    @Column(nullable = false)
    private String name; // Tên sản phẩm

    @Column(columnDefinition = "TEXT")
    private String description; // Mô tả sản phẩm

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price; // Giá sản phẩm

    @Column(nullable = false)
    private int stockQuantity; // Số lượng tồn kho

    @Column(length = 255)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category; // Danh mục liên kết

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails; // Danh sách chi tiết đơn hàng liên quan

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Size size; // Kích thước sản phẩm
}
