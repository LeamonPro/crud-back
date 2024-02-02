package com.example.crud.service;

import com.example.crud.dto.EmployeeDto;
import com.example.crud.dto.EmployeeDtoResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeDto save(EmployeeDto employeeDto);
    List<EmployeeDtoResponse> findAll();
    EmployeeDtoResponse getById(Integer id);

    void delete(Integer id);

    EmployeeDto update(EmployeeDto employeeDto,Integer id);
}
