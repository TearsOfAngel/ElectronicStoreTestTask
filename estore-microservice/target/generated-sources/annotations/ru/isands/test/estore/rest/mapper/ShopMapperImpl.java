package ru.isands.test.estore.rest.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.isands.test.estore.dao.entity.Shop;
import ru.isands.test.estore.dto.ShopDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-21T15:45:11+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.23 (Amazon.com Inc.)"
)
@Component
public class ShopMapperImpl implements ShopMapper {

    @Override
    public ShopDTO toDTO(Shop shop) {
        if ( shop == null ) {
            return null;
        }

        ShopDTO shopDTO = new ShopDTO();

        shopDTO.setName( shop.getName() );
        shopDTO.setAddress( shop.getAddress() );

        return shopDTO;
    }

    @Override
    public Shop toEntity(ShopDTO shopDTO) {
        if ( shopDTO == null ) {
            return null;
        }

        Shop shop = new Shop();

        shop.setName( shopDTO.getName() );
        shop.setAddress( shopDTO.getAddress() );

        return shop;
    }

    @Override
    public List<ShopDTO> toDTOList(List<Shop> shops) {
        if ( shops == null ) {
            return null;
        }

        List<ShopDTO> list = new ArrayList<ShopDTO>( shops.size() );
        for ( Shop shop : shops ) {
            list.add( toDTO( shop ) );
        }

        return list;
    }

    @Override
    public List<Shop> toEntityList(List<ShopDTO> shopDTOs) {
        if ( shopDTOs == null ) {
            return null;
        }

        List<Shop> list = new ArrayList<Shop>( shopDTOs.size() );
        for ( ShopDTO shopDTO : shopDTOs ) {
            list.add( toEntity( shopDTO ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(ShopDTO shopDTO, Shop shop) {
        if ( shopDTO == null ) {
            return;
        }

        shop.setName( shopDTO.getName() );
        shop.setAddress( shopDTO.getAddress() );
    }
}
