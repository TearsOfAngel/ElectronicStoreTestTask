package ru.isands.test.estore.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.isands.test.estore.dto.ShopDTO;
import ru.isands.test.estore.dao.entity.Shop;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShopMapper {

    ShopDTO toDTO(Shop shop);

    Shop toEntity(ShopDTO shopDTO);

    List<ShopDTO> toDTOList(List<Shop> shops);

    List<Shop> toEntityList(List<ShopDTO> shopDTOs);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(ShopDTO shopDTO, @MappingTarget Shop shop);

    default Shop map(Long id) {
        if (id == null) {
            return null;
        }
        Shop shop = new Shop();
        shop.setId(id);
        return shop;
    }

    default Long map(Shop shop) {
        if (shop == null) {
            return null;
        }
        return shop.getId();
    }
}
