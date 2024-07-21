package ru.isands.test.estore.rest.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.isands.test.estore.dao.entity.Employee;
import ru.isands.test.estore.dto.EmployeeDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-21T15:45:11+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.23 (Amazon.com Inc.)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDTO toDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setLastName( employee.getLastName() );
        employeeDTO.setFirstName( employee.getFirstName() );
        employeeDTO.setPatronymic( employee.getPatronymic() );
        employeeDTO.setBirthDate( employee.getBirthDate() );
        employeeDTO.setPositionId( employee.getPositionId() );
        employeeDTO.setShopId( employee.getShopId() );
        employeeDTO.setGender( employee.isGender() );

        return employeeDTO;
    }

    @Override
    public Employee toEntity(EmployeeDTO employeeDTO) {
        if ( employeeDTO == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setLastName( employeeDTO.getLastName() );
        employee.setFirstName( employeeDTO.getFirstName() );
        employee.setPatronymic( employeeDTO.getPatronymic() );
        employee.setBirthDate( employeeDTO.getBirthDate() );
        employee.setPositionId( employeeDTO.getPositionId() );
        employee.setShopId( employeeDTO.getShopId() );
        employee.setGender( employeeDTO.isGender() );

        return employee;
    }

    @Override
    public List<Employee> toEntityList(List<EmployeeDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( dtos.size() );
        for ( EmployeeDTO employeeDTO : dtos ) {
            list.add( toEntity( employeeDTO ) );
        }

        return list;
    }

    @Override
    public List<EmployeeDTO> toDTOList(List<Employee> employees) {
        if ( employees == null ) {
            return null;
        }

        List<EmployeeDTO> list = new ArrayList<EmployeeDTO>( employees.size() );
        for ( Employee employee : employees ) {
            list.add( toDto( employee ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(EmployeeDTO employeeDTO, Employee employee) {
        if ( employeeDTO == null ) {
            return;
        }

        employee.setLastName( employeeDTO.getLastName() );
        employee.setFirstName( employeeDTO.getFirstName() );
        employee.setPatronymic( employeeDTO.getPatronymic() );
        employee.setBirthDate( employeeDTO.getBirthDate() );
        employee.setPositionId( employeeDTO.getPositionId() );
        employee.setShopId( employeeDTO.getShopId() );
        employee.setGender( employeeDTO.isGender() );
    }
}
