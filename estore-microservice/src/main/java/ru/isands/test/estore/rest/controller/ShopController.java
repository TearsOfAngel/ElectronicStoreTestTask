package ru.isands.test.estore.rest.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.isands.test.estore.dto.ShopDTO;
import ru.isands.test.estore.dao.entity.Shop;
import ru.isands.test.estore.rest.service.ShopService;

import javax.validation.Valid;

@Tag(name = "Shop", description = "Сервис для добавления и управления магазинами")
@Validated
@RequestMapping("/estore/api/shop")
@RestController
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public Page<Shop> getShops(@RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        return shopService.getShops(page, limit);
    }

    @PostMapping
    public ResponseEntity<ShopDTO> createPosition(@Valid @RequestBody ShopDTO shop) {
        ShopDTO createdShop = shopService.createShop(shop);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdShop);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShopDTO> updateShop(@PathVariable Long id,
                                              @Valid @RequestBody ShopDTO shopDTO) {
        ShopDTO updatedShop = shopService.updateShop(id, shopDTO);
        return ResponseEntity.ok(updatedShop);
    }
}
