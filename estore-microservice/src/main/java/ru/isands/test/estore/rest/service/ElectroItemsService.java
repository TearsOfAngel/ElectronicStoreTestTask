package ru.isands.test.estore.rest.service;

import org.springframework.data.domain.Page;
import ru.isands.test.estore.dto.ElectroItemDTO;
import ru.isands.test.estore.dao.entity.ElectroItem;

public interface ElectroItemsService {

    Page<ElectroItem> getAllItems(Integer page, Integer limit);

    ElectroItemDTO getItemById(Long id);

    ElectroItemDTO createItem(ElectroItemDTO employeeDTO);

    ElectroItemDTO updateItem(Long id, ElectroItemDTO employeeDTO);
}
