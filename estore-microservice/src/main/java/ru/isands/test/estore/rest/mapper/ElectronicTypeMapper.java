package ru.isands.test.estore.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.isands.test.estore.dao.entity.PurchaseType;
import ru.isands.test.estore.dto.ElectronicTypeDTO;
import ru.isands.test.estore.dao.entity.ElectronicType;

@Mapper(componentModel = "spring")
public interface ElectronicTypeMapper {

    ElectronicTypeDTO toDTO(ElectronicType electronicType);

    ElectronicType toEntity(ElectronicTypeDTO electronicTypeDTO);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(ElectronicTypeDTO electronicTypeDTO, @MappingTarget ElectronicType electronicType);
}
