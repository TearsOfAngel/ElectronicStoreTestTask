package ru.isands.test.estore.rest.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.isands.test.estore.dto.PurchaseDTO;
import ru.isands.test.estore.dao.entity.Purchase;
import ru.isands.test.estore.rest.service.PurchaseService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Tag(name = "Purchase", description = "Сервис для просмотра покупок")
@Validated
@RequestMapping("/estore/api/purchases")
@RestController
public class PurchaseController {

    private final PurchaseService purchaseService;

    @GetMapping
    public Page<Purchase> getPurchases(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit,
            @RequestParam(value = "sortBy", defaultValue = "purchaseDate") String sortBy,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection) {
        return purchaseService.getAllPurchases(page, limit, sortBy, sortDirection);
    }

    @GetMapping("/{id}")
    public Purchase getPurchase(@PathVariable Long id) {
        return purchaseService.getPurchase(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseDTO> update(@PathVariable Long id,
                                              @Valid @RequestBody PurchaseDTO purchaseDTO) {
        PurchaseDTO updatedPurchase = purchaseService.updatePurchase(id, purchaseDTO);
        return ResponseEntity.ok(updatedPurchase);
    }

    @PostMapping
    public ResponseEntity<String> addPurchase(@Valid @RequestBody PurchaseDTO purchaseDTO) {
        return purchaseService.addPurchase(purchaseDTO);
    }
}
