package ru.isands.test.estore.rest.service;

import org.springframework.data.domain.Page;
import ru.isands.test.estore.dto.PositionTypeDTO;
import ru.isands.test.estore.dao.entity.PositionType;

public interface PositionTypeService {

    Page<PositionType> getPositions(Integer page, Integer limit);

    PositionTypeDTO getPosition(Long id);

    PositionTypeDTO updatePosition(Long id, PositionTypeDTO positionTypeDTO);
}
