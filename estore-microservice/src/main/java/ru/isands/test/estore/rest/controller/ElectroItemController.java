package ru.isands.test.estore.rest.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.isands.test.estore.dto.ElectroItemDTO;
import ru.isands.test.estore.dao.entity.ElectroItem;
import ru.isands.test.estore.rest.service.ElectroItemsService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Tag(name = "Electronics", description = "Сервис управления электротоварами")
@Validated
@RequestMapping("/estore/api/electronics")
@RestController
public class ElectroItemController {

    private final ElectroItemsService electroItemsService;

    @GetMapping
    public Page<ElectroItem> getElectroItems(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                             @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        return electroItemsService.getAllItems(page, limit);
    }

    @GetMapping("/{id}")
    public ElectroItemDTO getElectronicItem(@PathVariable Long id) {
        return electroItemsService.getItemById(id);
    }

    @PostMapping
    public ResponseEntity<ElectroItemDTO> addElectronicItem(@Valid @RequestBody ElectroItemDTO electroItemDTO) {
        ElectroItemDTO createdItem = electroItemsService.createItem(electroItemDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ElectroItemDTO> updateItem(@PathVariable Long id,
                                                     @Valid @RequestBody ElectroItemDTO electroItemDTO) {
        ElectroItemDTO updatedItem = electroItemsService.updateItem(id, electroItemDTO);
        return ResponseEntity.ok(updatedItem);
    }
}
