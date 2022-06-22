package com.example.Hasscript.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "departmentName")
    private String  departmentName;
    @OneToMany (mappedBy = "department")
    private Set<User> user;
    @ManyToOne
    @JoinColumn(name="hospital_id")
    private Hospital hospital;
    public Department(){};
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

}
