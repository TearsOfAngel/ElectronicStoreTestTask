package ru.isands.test.estore.rest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.isands.test.estore.dto.ElectronicTypeDTO;
import ru.isands.test.estore.dao.entity.ElectronicType;
import ru.isands.test.estore.dao.repo.ElectroTypeRepository;
import ru.isands.test.estore.rest.exception.ResourceNotFoundException;
import ru.isands.test.estore.rest.mapper.ElectronicTypeMapper;
import ru.isands.test.estore.rest.service.ElectronicTypeService;

@RequiredArgsConstructor
@Service
public class ElectronicTypeServiceImpl implements ElectronicTypeService {

    private final ElectroTypeRepository electroTypeRepository;

    private final ElectronicTypeMapper electronicTypeMapper;

    @Override
    public Page<ElectronicType> getAllTypes(Integer page, Integer limit) {
        return electroTypeRepository.findAll(PageRequest.of(page, limit));
    }

    @Override
    public ElectronicTypeDTO getTypeById(Long id) {
        ElectronicType electronicType = electroTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Electronic type with id: " + id + " not found"));
        return electronicTypeMapper.toDTO(electronicType);
    }

    @Override
    public ElectronicTypeDTO createType(ElectronicTypeDTO electronicTypeDTO) {
        return null;
    }

    @Override
    public ElectronicTypeDTO updateType(Long id, ElectronicTypeDTO electronicTypeDTO) {
        ElectronicType existingType = electroTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Electronic type with id: " + id + " not found"));
        electronicTypeMapper.updateEntityFromDto(electronicTypeDTO, existingType);
        ElectronicType updatedElectronicType = electroTypeRepository.save(existingType);
        return electronicTypeMapper.toDTO(updatedElectronicType);
    }

}
