package ru.isands.test.estore.rest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.isands.test.estore.dto.PurchaseTypeDTO;
import ru.isands.test.estore.dao.entity.PurchaseType;
import ru.isands.test.estore.dao.repo.PurchaseTypeRepository;
import ru.isands.test.estore.rest.exception.ResourceNotFoundException;
import ru.isands.test.estore.rest.mapper.PurchaseTypeMapper;
import ru.isands.test.estore.rest.service.PurchaseTypeService;

@RequiredArgsConstructor
@Service
public class PurchaseTypeServiceImpl implements PurchaseTypeService {

    private final PurchaseTypeRepository purchaseTypeRepository;

    private final PurchaseTypeMapper purchaseTypeMapper;

    @Override
    public Page<PurchaseType> getAllTypes(Integer page, Integer limit) {
        return purchaseTypeRepository.findAll(PageRequest.of(page, limit));
    }

    @Override
    public PurchaseTypeDTO getPurchaseType(Long id) {
        PurchaseType purchaseType = purchaseTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Purchase type with id: " + id + " not found"));
        return purchaseTypeMapper.toDTO(purchaseType);
    }

    @Override
    public PurchaseTypeDTO addPurchaseType(PurchaseTypeDTO purchaseTypeDTO) {
        PurchaseType purchaseType = purchaseTypeMapper.toEntity(purchaseTypeDTO);
        PurchaseType savedPurchaseType = purchaseTypeRepository.save(purchaseType);
        return purchaseTypeMapper.toDTO(savedPurchaseType);
    }

    @Override
    public PurchaseTypeDTO updatePurchaseType(Long id, PurchaseTypeDTO purchaseTypeDTO) {
        PurchaseType existingPurchaseType = purchaseTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Purchase type with id: " + id + " not found"));
        purchaseTypeMapper.updateEntityFromDto(purchaseTypeDTO, existingPurchaseType);
        PurchaseType updatedPurchaseType = purchaseTypeRepository.save(existingPurchaseType);
        return purchaseTypeMapper.toDTO(updatedPurchaseType);
    }
}
