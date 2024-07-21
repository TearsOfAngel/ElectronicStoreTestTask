package ru.isands.test.estore.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.isands.test.estore.dto.PurchaseTypeDTO;
import ru.isands.test.estore.dao.entity.PurchaseType;

@Mapper(componentModel = "spring")
public interface PurchaseTypeMapper {

    PurchaseTypeDTO toDTO(PurchaseType purchaseType);

    PurchaseType toEntity(PurchaseTypeDTO purchaseTypeDTO);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(PurchaseTypeDTO purchaseTypeDTO, @MappingTarget PurchaseType purchaseType);

    default PurchaseType map(Long id) {
        if (id == null) {
            return null;
        }
        PurchaseType purchaseType = new PurchaseType();
        purchaseType.setId(id);
        return purchaseType;
    }

    default Long map(PurchaseType purchaseType) {
        if (purchaseType == null) {
            return null;
        }
        return purchaseType.getId();
    }
}
