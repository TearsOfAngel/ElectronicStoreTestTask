package ru.isands.test.estore.rest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.isands.test.estore.dto.PurchaseDTO;
import ru.isands.test.estore.dao.entity.ElectroShop;
import ru.isands.test.estore.dao.entity.ElectronicShopItemId;
import ru.isands.test.estore.dao.entity.Purchase;
import ru.isands.test.estore.dao.repo.ElectronicShopRepository;
import ru.isands.test.estore.dao.repo.PurchaseRepository;
import ru.isands.test.estore.rest.exception.ResourceNotFoundException;
import ru.isands.test.estore.rest.mapper.PurchaseMapper;
import ru.isands.test.estore.rest.service.PurchaseService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;

    private final ElectronicShopRepository electronicShopRepository;

    private final PurchaseMapper purchaseMapper;


    @Override
    public Page<Purchase> getAllPurchases(Integer page, Integer limit, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        PageRequest pageRequest = PageRequest.of(page, limit, sort);
        return purchaseRepository.findAll(pageRequest);
    }

    @Override
    public Purchase getPurchase(Long id) {
        return purchaseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Purchase not found"));
    }

    @Override
    public ResponseEntity<String> addPurchase(PurchaseDTO purchaseDTO) {
        Long itemId = purchaseDTO.getElectroId();
        Long storeId = purchaseDTO.getShopId();
        ElectronicShopItemId electronicShopItemId = new ElectronicShopItemId(storeId, itemId);

        Optional<ElectroShop> electronicItemAmount = electronicShopRepository.findById(electronicShopItemId);

        //TODO: Подумать над тем нужно ли декрементить количество товара в магазине
        if (electronicItemAmount.isPresent()) {
            ElectroShop electroShop = electronicItemAmount.get();
            int amountOfItemInStore = electroShop.getCount();

            if (amountOfItemInStore > 0) {
                Purchase purchase = purchaseMapper.toEntity(purchaseDTO);
                purchaseRepository.save(purchase);
                return ResponseEntity.status(HttpStatus.CREATED).body("Purchase created successfully");
            }
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Item not available in store");
    }

    @Override
    public PurchaseDTO updatePurchase(Long id, PurchaseDTO purchaseDTO) {
        Purchase existingPurchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        purchaseMapper.updateEntityFromDto(purchaseDTO, existingPurchase);
        Purchase updatedPurchase = purchaseRepository.save(existingPurchase);
        return purchaseMapper.toDto(updatedPurchase);
    }
}

