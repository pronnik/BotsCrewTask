package com.example.botscrewtask.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Table(name = "lectors")
@Entity
@Getter
public class LectorEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer lectorId;

    @Column(name = "name", nullable = false)
    private String lectorName;

    @Column(name = "degree", nullable = false)
    private Integer lectorDegree;


}
