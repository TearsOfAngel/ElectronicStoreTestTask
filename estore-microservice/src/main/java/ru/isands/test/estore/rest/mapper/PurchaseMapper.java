package ru.isands.test.estore.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.isands.test.estore.dto.PurchaseDTO;
import ru.isands.test.estore.dao.entity.Purchase;

@Mapper(componentModel = "spring", uses = {EmployeeMapper.class, ShopMapper.class, PurchaseTypeMapper.class})
public interface PurchaseMapper {

    Purchase toEntity(PurchaseDTO purchaseDTO);

    PurchaseDTO toDto(Purchase purchase);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(PurchaseDTO purchaseDTO, @MappingTarget Purchase purchase);
}
