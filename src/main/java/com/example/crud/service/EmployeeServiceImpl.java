package com.example.crud.service;

import com.example.crud.dao.EmployeeDao;
import com.example.crud.dto.EmployeeDto;
import com.example.crud.dto.EmployeeDtoResponse;
import com.example.crud.model.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class EmployeeServiceImpl implements  EmployeeService{
    private EmployeeDao employeeDao;
    private ModelMapper modelMapper;
    public EmployeeServiceImpl(EmployeeDao employeeDao , ModelMapper modelMapper){
        this.employeeDao=employeeDao;
        this.modelMapper=modelMapper;
    }
    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee employee=modelMapper.map(employeeDto,Employee.class);
        Employee savedEntity=employeeDao.save(employee);
        return modelMapper.map(savedEntity,EmployeeDto.class);

    }

    @Override
    public List<EmployeeDtoResponse> findAll() {
        return employeeDao.findAll().stream().map(
                    el ->modelMapper.map(el, EmployeeDtoResponse.class)
            ).collect(Collectors.toList());
        }

    @Override
    public EmployeeDtoResponse getById(Integer id) {
        Optional<Employee> empl=employeeDao.findById(id);
        return modelMapper.map(empl,EmployeeDtoResponse.class);
    }

    @Override
    public void delete(Integer id) {
        employeeDao.deleteById(id);
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto,Integer id) {
        Optional<Employee> emp=employeeDao.findById(id);
        if(emp.isPresent()) {
            Employee employeeEntity = modelMapper.map(employeeDto, Employee.class);
            employeeEntity.setEmployeeId(id);
            Employee saved=employeeDao.save(employeeEntity);
            return modelMapper.map(saved,EmployeeDto.class);
        }
        else
            return null;
    }


    }