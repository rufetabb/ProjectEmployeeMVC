package com.example.projectemployeemvc.mapper;

import com.example.projectemployeemvc.dao.entity.Employee;
import com.example.projectemployeemvc.model.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE= Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto employeeToDto(Employee employee);



}