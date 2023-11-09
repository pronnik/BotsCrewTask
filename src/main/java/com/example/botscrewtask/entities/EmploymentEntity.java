package com.example.botscrewtask.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Table(name = "employments")
@Entity
@Getter
public class EmploymentEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "department_id", nullable = false)
    private Integer departmentId;

    @ManyToOne
    @JoinColumn(name="lector_id")
    private LectorEntity lector;

    @Column(name = "salary", nullable = false)
    private Integer salary;


}
