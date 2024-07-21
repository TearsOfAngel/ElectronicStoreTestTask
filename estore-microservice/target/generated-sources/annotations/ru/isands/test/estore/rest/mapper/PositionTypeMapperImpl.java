package ru.isands.test.estore.rest.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.isands.test.estore.dao.entity.PositionType;
import ru.isands.test.estore.dto.PositionTypeDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-21T15:45:11+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.23 (Amazon.com Inc.)"
)
@Component
public class PositionTypeMapperImpl implements PositionTypeMapper {

    @Override
    public PositionTypeDTO toDTO(PositionType positionType) {
        if ( positionType == null ) {
            return null;
        }

        PositionTypeDTO positionTypeDTO = new PositionTypeDTO();

        positionTypeDTO.setName( positionType.getName() );

        return positionTypeDTO;
    }

    @Override
    public PositionType toEntity(PositionTypeDTO positionTypeDTO) {
        if ( positionTypeDTO == null ) {
            return null;
        }

        PositionType positionType = new PositionType();

        positionType.setName( positionTypeDTO.getName() );

        return positionType;
    }

    @Override
    public void updateEntityFromDto(PositionTypeDTO positionTypeDTO, PositionType positionType) {
        if ( positionTypeDTO == null ) {
            return;
        }

        positionType.setName( positionTypeDTO.getName() );
    }
}
