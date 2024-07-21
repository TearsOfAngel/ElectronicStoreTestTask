package ru.isands.test.estore.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.isands.test.estore.dto.PositionTypeDTO;
import ru.isands.test.estore.dao.entity.PositionType;

@Mapper(componentModel = "spring")
public interface PositionTypeMapper {

    PositionTypeDTO toDTO(PositionType positionType);

    PositionType toEntity(PositionTypeDTO positionTypeDTO);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(PositionTypeDTO positionTypeDTO, @MappingTarget PositionType positionType);
}
