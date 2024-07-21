package ru.isands.test.estore.rest.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.isands.test.estore.dto.PositionTypeDTO;
import ru.isands.test.estore.dao.entity.PositionType;
import ru.isands.test.estore.rest.service.PositionTypeService;

import javax.validation.Valid;

@RequiredArgsConstructor
@Tag(name = "Positions", description = "Позволяет работать с должностями сотрудников")
@Validated
@RequestMapping("/estore/api/positions")
@RestController
public class EmployeePositionController {

    private final PositionTypeService positionTypeService;

    @GetMapping
    public Page<PositionType> getPositions(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                           @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        return positionTypeService.getPositions(page, limit);
    }

    @GetMapping("/{id}")
    public PositionTypeDTO getPosition(@PathVariable Long id) {
        return positionTypeService.getPosition(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PositionTypeDTO> updatePosition(@PathVariable Long id,
                                                          @Valid @RequestBody PositionTypeDTO positionTypeDTO) {
        PositionTypeDTO updatedPosition = positionTypeService.updatePosition(id, positionTypeDTO);
        return ResponseEntity.ok(updatedPosition);
    }
}
