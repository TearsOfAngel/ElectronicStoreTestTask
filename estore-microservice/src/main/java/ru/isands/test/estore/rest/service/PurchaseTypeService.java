package ru.isands.test.estore.rest.service;

import org.springframework.data.domain.Page;
import ru.isands.test.estore.dto.PurchaseTypeDTO;
import ru.isands.test.estore.dao.entity.PurchaseType;

public interface PurchaseTypeService {

    Page<PurchaseType> getAllTypes(Integer page, Integer limit);

    PurchaseTypeDTO getPurchaseType(Long id);

    PurchaseTypeDTO addPurchaseType(PurchaseTypeDTO purchaseTypeDTO);

    PurchaseTypeDTO updatePurchaseType(Long id, PurchaseTypeDTO purchaseTypeDTO);
}
