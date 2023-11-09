package com.example.botscrewtask.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Table(name = "departments")
@Entity
@Getter
public class DepartmentEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer departmentId;

    @Column(name = "name", nullable = false)
    private String departmentName;

    @Column(name = "department_head", nullable = false)
    private Integer departmentHeadId;

}
