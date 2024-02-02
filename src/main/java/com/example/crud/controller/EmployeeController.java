package com.example.crud.controller;

import com.example.crud.dto.EmployeeDto;
import com.example.crud.dto.EmployeeDtoResponse;
import com.example.crud.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public EmployeeDto save(@RequestBody EmployeeDto employeeDto){
        return employeeService.save(employeeDto);
    }
    @GetMapping("/")
    public List<EmployeeDtoResponse> findAll(){
        return employeeService.findAll();
    }
    @GetMapping("/id/{id}")
    public EmployeeDtoResponse getById(@PathVariable("id") Integer id){
        return employeeService.getById(id);
    }
    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable("id") Integer id){
        employeeService.delete(id);
    }

    @PutMapping("/id/{id}")
    public EmployeeDto update(@RequestBody EmployeeDto employeeDto,@PathVariable("id") Integer id){
        return employeeService.update(employeeDto,id);
    }
}
