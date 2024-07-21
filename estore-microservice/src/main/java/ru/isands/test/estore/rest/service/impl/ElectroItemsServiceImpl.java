package ru.isands.test.estore.rest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.isands.test.estore.dto.ElectroItemDTO;
import ru.isands.test.estore.dao.entity.ElectroItem;
import ru.isands.test.estore.dao.repo.ElectroItemRepository;
import ru.isands.test.estore.rest.exception.ResourceNotFoundException;
import ru.isands.test.estore.rest.mapper.ElectroItemMapper;
import ru.isands.test.estore.rest.service.ElectroItemsService;

@RequiredArgsConstructor
@Service
public class ElectroItemsServiceImpl implements ElectroItemsService {

    private final ElectroItemRepository electroItemRepository;

    private final ElectroItemMapper electroItemMapper;

    @Override
    public Page<ElectroItem> getAllItems(Integer page, Integer limit) {
        return electroItemRepository.findAll(PageRequest.of(page, limit));
    }

    @Override
    public ElectroItemDTO getItemById(Long id) {
        ElectroItem electroItem = electroItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item with id: " + id + " not found"));
        return electroItemMapper.toDto(electroItem);
    }

    @Override
    public ElectroItemDTO createItem(ElectroItemDTO electroItemDTO) {
        return null;
    }

    @Override
    public ElectroItemDTO updateItem(Long id, ElectroItemDTO electroItemDTO) {
        ElectroItem existingItem = electroItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Electronic device with id: " + id + " not found"));
        electroItemMapper.updateEntityFromDto(electroItemDTO, existingItem);
        ElectroItem updatedItem = electroItemRepository.save(existingItem);
        return electroItemMapper.toDto(updatedItem);
    }
}
