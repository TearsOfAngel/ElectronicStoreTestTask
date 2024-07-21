package ru.isands.test.estore.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.isands.test.estore.dto.EmployeeDTO;
import ru.isands.test.estore.dao.entity.Employee;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDTO toDto(Employee employee);

    Employee toEntity(EmployeeDTO employeeDTO);

    List<Employee> toEntityList(List<EmployeeDTO> dtos);

    List<EmployeeDTO> toDTOList(List<Employee> employees);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(EmployeeDTO employeeDTO, @MappingTarget Employee employee);

    default Employee map(Long id) {
        if (id == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setId(id);
        return employee;
    }

    default Long map(Employee employee) {
        if (employee == null) {
            return null;
        }
        return employee.getId();
    }
}
