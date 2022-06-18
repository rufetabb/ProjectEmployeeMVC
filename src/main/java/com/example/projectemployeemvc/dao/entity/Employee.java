package com.example.projectemployeemvc.dao.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "employee_data")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private Integer age;


}
