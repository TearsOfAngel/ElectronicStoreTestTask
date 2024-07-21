package ru.isands.test.estore.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.isands.test.estore.dao.entity.ElectronicType;
import ru.isands.test.estore.dto.ElectroItemDTO;
import ru.isands.test.estore.dao.entity.ElectroItem;


@Mapper(componentModel = "spring")
public interface ElectroItemMapper {

    ElectroItemDTO toDto(ElectroItem electroItem);

    ElectroItem toEntity(ElectroItemDTO electroItemDTO);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(ElectroItemDTO electroItemDTO, @MappingTarget ElectroItem electroItem);

    default ElectroItem map(Long id) {
        if (id == null) {
            return null;
        }
        ElectroItem electroItem = new ElectroItem();
        electroItem.setId(id);
        return electroItem;
    }

    default Long map(ElectroItem electroItem) {
        if (electroItem == null) {
            return null;
        }
        return electroItem.getId();
    }
}
