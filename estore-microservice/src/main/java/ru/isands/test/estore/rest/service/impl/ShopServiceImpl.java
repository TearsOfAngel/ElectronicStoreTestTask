package ru.isands.test.estore.rest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.isands.test.estore.dto.ShopDTO;
import ru.isands.test.estore.dao.entity.Shop;
import ru.isands.test.estore.dao.repo.ShopRepository;
import ru.isands.test.estore.rest.exception.ResourceNotFoundException;
import ru.isands.test.estore.rest.mapper.ShopMapper;
import ru.isands.test.estore.rest.service.ShopService;

@RequiredArgsConstructor
@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;
    private final ShopMapper shopMapper;

    @Override
    public Page<Shop> getShops(Integer page, Integer limit) {
        return shopRepository.findAll(PageRequest.of(page, limit));
    }

    @Override
    public ShopDTO getShop(Long id) {
        Shop shop = shopRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shop with id: " + id + " not found"));
        return shopMapper.toDTO(shop);
    }

    @Override
    public ShopDTO createShop(ShopDTO shopDto) {
        Shop shopToSave = shopMapper.toEntity(shopDto);
        Shop savedShop = shopRepository.save(shopToSave);
        return shopMapper.toDTO(savedShop);
    }

    @Override
    public ShopDTO updateShop(Long id, ShopDTO shopDTO) {
        Shop existingShop = shopRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shop with id: " + id + " not found"));
        shopMapper.updateEntityFromDto(shopDTO, existingShop);
        Shop updatedShop = shopRepository.save(existingShop);
        return shopMapper.toDTO(updatedShop);
    }
}
