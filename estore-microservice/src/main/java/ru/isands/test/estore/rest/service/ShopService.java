package ru.isands.test.estore.rest.service;

import org.springframework.data.domain.Page;
import ru.isands.test.estore.dto.ShopDTO;
import ru.isands.test.estore.dao.entity.Shop;

public interface ShopService {

    Page<Shop> getShops(Integer page, Integer limit);

    ShopDTO getShop(Long id);

    ShopDTO createShop(ShopDTO shop);

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

    ShopDTO updateShop(Long id, ShopDTO shopDTO);
}
