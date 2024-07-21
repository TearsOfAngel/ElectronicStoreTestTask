package ru.isands.test.estore.rest.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.isands.test.estore.dto.PositionTypeDTO;
import ru.isands.test.estore.dao.entity.PositionType;
import ru.isands.test.estore.dao.repo.PositionTypeRepository;
import ru.isands.test.estore.rest.exception.ResourceNotFoundException;
import ru.isands.test.estore.rest.mapper.PositionTypeMapper;
import ru.isands.test.estore.rest.service.PositionTypeService;

@RequiredArgsConstructor
@Service
public class PositionTypeServiceImpl implements PositionTypeService {

    private final PositionTypeRepository positionTypeRepository;

    private final PositionTypeMapper positionTypeMapper;


    @Override
    public Page<PositionType> getPositions(Integer page, Integer limit) {
        return positionTypeRepository.findAll(PageRequest.of(page, limit));
    }

    @Override
    public PositionTypeDTO getPosition(Long id) {
        PositionType positionType = positionTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Position with id: " + id + " not found"));
        return positionTypeMapper.toDTO(positionType);
    }

    @Override
    public PositionTypeDTO updatePosition(Long id, PositionTypeDTO positionTypeDTO) {
        PositionType existingPosition = positionTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Position with id: " + id + " not found"));
        positionTypeMapper.updateEntityFromDto(positionTypeDTO, existingPosition);
        PositionType updatedPosition = positionTypeRepository.save(existingPosition);
        return positionTypeMapper.toDTO(updatedPosition);
    }

}
