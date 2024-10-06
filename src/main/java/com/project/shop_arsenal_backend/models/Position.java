package com.project.shop_arsenal_backend.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long positionId;

    @Column(name = "position_name", unique = true, nullable = false)
    private String positionName; // Tên chức vụ

    @Column(columnDefinition = "TEXT")
    private String description; // Mô tả chức vụ
}
