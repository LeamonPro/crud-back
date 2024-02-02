package com.example.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDtoResponse {
    private Integer employeeId;
    private String name;
    private String contactNumber;
    private String adresse;
    private String departement;
    private String gender;
    private String skills;
}
