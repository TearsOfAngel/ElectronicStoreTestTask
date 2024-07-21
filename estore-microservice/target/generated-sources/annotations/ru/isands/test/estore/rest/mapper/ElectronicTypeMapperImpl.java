package ru.isands.test.estore.rest.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.isands.test.estore.dao.entity.ElectronicType;
import ru.isands.test.estore.dto.ElectronicTypeDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-21T15:45:11+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.23 (Amazon.com Inc.)"
)
@Component
public class ElectronicTypeMapperImpl implements ElectronicTypeMapper {

    @Override
    public ElectronicTypeDTO toDTO(ElectronicType electronicType) {
        if ( electronicType == null ) {
            return null;
        }

        ElectronicTypeDTO electronicTypeDTO = new ElectronicTypeDTO();

        electronicTypeDTO.setName( electronicType.getName() );

        return electronicTypeDTO;
    }

    @Override
    public ElectronicType toEntity(ElectronicTypeDTO electronicTypeDTO) {
        if ( electronicTypeDTO == null ) {
            return null;
        }

        ElectronicType electronicType = new ElectronicType();

        electronicType.setName( electronicTypeDTO.getName() );

        return electronicType;
    }

    @Override
    public void updateEntityFromDto(ElectronicTypeDTO electronicTypeDTO, ElectronicType electronicType) {
        if ( electronicTypeDTO == null ) {
            return;
        }

        electronicType.setName( electronicTypeDTO.getName() );
    }
}
