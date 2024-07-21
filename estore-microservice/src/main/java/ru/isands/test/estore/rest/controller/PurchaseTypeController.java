package ru.isands.test.estore.rest.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.isands.test.estore.dto.PurchaseTypeDTO;
import ru.isands.test.estore.dao.entity.PurchaseType;
import ru.isands.test.estore.rest.service.PurchaseTypeService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Tag(name = "Purchase type", description = "Позволяет работать с типами покупок")
@Validated
@RequestMapping("/estore/api/purchase-types")
@RestController
public class PurchaseTypeController {

    private final PurchaseTypeService purchaseTypeService;

    @GetMapping
    public Page<PurchaseType> getPurchaseTypes(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                               @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        return purchaseTypeService.getAllTypes(page, limit);
    }

    @GetMapping("/{id}")
    public PurchaseTypeDTO getPurchaseType(@PathVariable Long id) {
        return purchaseTypeService.getPurchaseType(id);
    }

    @PostMapping
    public ResponseEntity<PurchaseTypeDTO> addPurchaseType(@Valid @RequestBody PurchaseTypeDTO purchaseTypeDTO) {
        PurchaseTypeDTO createdPurchaseType = purchaseTypeService.addPurchaseType(purchaseTypeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPurchaseType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseTypeDTO> updatePurchaseType(@PathVariable Long id,
                                                              @Valid @RequestBody PurchaseTypeDTO purchaseTypeDTO) {
        PurchaseTypeDTO updatedPurchaseType = purchaseTypeService.updatePurchaseType(id, purchaseTypeDTO);
        return ResponseEntity.ok(updatedPurchaseType);
    }
}
