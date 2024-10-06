package com.project.shop_arsenal_backend.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId; // ID của đơn hàng

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User buyer; // Người mua hàng

    @Column(nullable = false)
    private LocalDateTime orderDate; // Ngày đặt hàng

    @Column(nullable = false, unique = true)
    private String code; // Mã đơn hàng

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails; // Chi tiết các mục hàng trong đơn hàng
}
