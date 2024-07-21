package ru.isands.test.estore.rest.csv.parsers.impl;

import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import ru.isands.test.estore.dao.entity.PositionType;
import ru.isands.test.estore.dao.repo.PositionTypeRepository;
import ru.isands.test.estore.rest.csv.parsers.CSVParserService;

@Service
public class PositionTypeCSVParser implements CSVParserService {

    private final PositionTypeRepository positionTypeRepository;

    public PositionTypeCSVParser(PositionTypeRepository positionTypeRepository) {
        this.positionTypeRepository = positionTypeRepository;
    }

    @Override
    public void parseAndSave(CSVRecord record) {
        PositionType positionType = new PositionType();
        positionType.setId(Long.valueOf(record.get(0)));
        positionType.setName(record.get(1));
        positionTypeRepository.save(positionType);
    }
}
