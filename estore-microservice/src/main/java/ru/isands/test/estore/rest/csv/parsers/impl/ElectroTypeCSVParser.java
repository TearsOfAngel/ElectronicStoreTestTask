package ru.isands.test.estore.rest.csv.parsers.impl;

import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import ru.isands.test.estore.dao.entity.ElectronicType;
import ru.isands.test.estore.dao.repo.ElectroTypeRepository;
import ru.isands.test.estore.rest.csv.parsers.CSVParserService;

@Service
public class ElectroTypeCSVParser implements CSVParserService {

    private final ElectroTypeRepository electroTypeRepository;

    public ElectroTypeCSVParser(ElectroTypeRepository electroTypeRepository) {
        this.electroTypeRepository = electroTypeRepository;
    }

    @Override
    public void parseAndSave(CSVRecord record) {
        ElectronicType electronicType = new ElectronicType();
        electronicType.setId(Long.valueOf(record.get(0)));
        electronicType.setName(record.get(1));
        electroTypeRepository.save(electronicType);
    }
}
