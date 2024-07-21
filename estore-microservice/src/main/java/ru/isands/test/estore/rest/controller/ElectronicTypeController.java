package ru.isands.test.estore.rest.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.isands.test.estore.dto.ElectronicTypeDTO;
import ru.isands.test.estore.dao.entity.ElectronicType;
import ru.isands.test.estore.rest.service.ElectronicTypeService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Tag(name = "Electronic type", description = "Позволяет работать с типами электроники")
@Validated
@RequestMapping("/estore/api/electronic-types")
@RestController
public class ElectronicTypeController {

    private final ElectronicTypeService electronicTypeService;

    @GetMapping
    public Page<ElectronicType> getElectronicTypes(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                   @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        return electronicTypeService.getAllTypes(page, limit);
    }

    @GetMapping("/{id}")
    public ElectronicTypeDTO getElectronicType(@PathVariable Long id) {
        return electronicTypeService.getTypeById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ElectronicTypeDTO> updateElectronicType(@PathVariable Long id,
                                                                  @Valid @RequestBody ElectronicTypeDTO electronicTypeDTO) {
        ElectronicTypeDTO updatedElectronicType = electronicTypeService.updateType(id, electronicTypeDTO);
        return ResponseEntity.ok(updatedElectronicType);
    }
}
