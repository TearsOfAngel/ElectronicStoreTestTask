package ru.isands.test.estore.rest.service;

import org.springframework.data.domain.Page;
import ru.isands.test.estore.dto.ElectronicTypeDTO;
import ru.isands.test.estore.dao.entity.ElectronicType;

public interface ElectronicTypeService {

    Page<ElectronicType> getAllTypes(Integer page, Integer limit);

    ElectronicTypeDTO getTypeById(Long id);

    ElectronicTypeDTO createType(ElectronicTypeDTO electronicTypeDTO);

    ElectronicTypeDTO updateType(Long id, ElectronicTypeDTO electronicTypeDTO);
}
