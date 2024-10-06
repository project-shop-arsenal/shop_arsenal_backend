package com.project.shop_arsenal_backend.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "TypeTokens")
public class TypeTokens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "typeToken", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserToken> userTokens; // Danh sách các mã thông báo liên quan

    // Constructors, Getters and Setters if needed (Lombok @Data đã tạo sẵn)
}
