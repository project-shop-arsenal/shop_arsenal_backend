package com.project.shop_arsenal_backend.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId; // ID của danh mục

    @Column(nullable = false, unique = true)
    private String name; // Tên danh mục, không được trùng

    @Column(columnDefinition = "TEXT")
    private String description; // Mô tả chi tiết về danh mục

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> products; // Danh sách sản phẩm thuộc danh mục này
}
