package com.ssafy.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Customer {
    @Id @Column(length = 10)
    private String id;
    @Column(length = 10, nullable = false)
    private String password;
    @Column(length = 16)
    private String name;
}
