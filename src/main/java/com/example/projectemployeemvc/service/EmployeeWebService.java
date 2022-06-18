package com.example.projectemployeemvc.service;

import com.example.projectemployeemvc.dao.entity.Employee;
import com.example.projectemployeemvc.mapper.EmployeeMapper;
import com.example.projectemployeemvc.model.EmployeeDto;
import com.example.projectemployeemvc.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeWebService {



    private final EmployeeRepository employeeRepository;

    public EmployeeWebService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;

    }


    public List<EmployeeDto> findAllEmployee(){
        var employeeList= employeeRepository.findAll();
        var employeeDtoList= employeeList
                .stream()
                .map(i-> EmployeeMapper.INSTANCE.employeeToDto(i))
                .collect(Collectors.toList());

        return employeeDtoList;
    }

    public EmployeeDto addEmployee(Employee employee){
        var employeeEntity=employeeRepository.save(employee);
        var employeeDto=EmployeeMapper.INSTANCE.employeeToDto(employeeEntity);
        return employeeDto;


    }
    public EmployeeDto updateEmployeeById(Long id){

        var existingEmployee =employeeRepository.existsById(id);
        if(!existingEmployee) employeeRepository.findById(id).orElseGet(Employee::new);
        var employee= employeeRepository.findById(id).get();
        var  employeeDto =addEmployee(employee);

        return employeeDto;


    }
    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }

}
