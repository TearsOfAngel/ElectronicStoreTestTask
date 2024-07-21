package ru.isands.test.estore.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import ru.isands.test.estore.dto.PurchaseDTO;
import ru.isands.test.estore.dao.entity.Purchase;

public interface PurchaseService {

    Page<Purchase> getAllPurchases(Integer page, Integer limit, String sortBy, String sortDirection);

    Purchase getPurchase(Long id);

    ResponseEntity<String> addPurchase(PurchaseDTO purchaseDTO);

    PurchaseDTO updatePurchase(Long id, PurchaseDTO purchaseDTO);
}
