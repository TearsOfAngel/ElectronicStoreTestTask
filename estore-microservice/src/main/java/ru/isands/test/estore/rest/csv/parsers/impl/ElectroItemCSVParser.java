package ru.isands.test.estore.rest.csv.parsers.impl;

import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isands.test.estore.dao.entity.ElectroItem;
import ru.isands.test.estore.dao.entity.ElectronicType;
import ru.isands.test.estore.dao.repo.ElectroItemRepository;
import ru.isands.test.estore.dao.repo.ElectroTypeRepository;
import ru.isands.test.estore.rest.csv.parsers.CSVParserService;

@Service
public class ElectroItemCSVParser implements CSVParserService {
    private final ElectroItemRepository electroItemRepository;
    private final ElectroTypeRepository electronicTypeRepository;

    public ElectroItemCSVParser(ElectroItemRepository electroItemRepository,
                                ElectroTypeRepository electronicTypeRepository) {
        this.electroItemRepository = electroItemRepository;
        this.electronicTypeRepository = electronicTypeRepository;
    }

    @Override
    @Transactional
    public void parseAndSave(CSVRecord record) {
        try {
            String name = record.get(1);
            Long typeId = Long.parseLong(record.get(2));
            Long price = Long.parseLong(record.get(3));
            int count = Integer.parseInt(record.get(4));
            boolean archive = "1".equals(record.get(5));
            String description = record.get(6);

            ElectronicType electronicType = electronicTypeRepository.findById(typeId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid electronic type ID: " + typeId));

            ElectroItem electroItem = new ElectroItem();
            electroItem.setName(name);
            electroItem.setElectronicType(electronicType);
            electroItem.setPrice(price);
            electroItem.setCount(count);
            electroItem.setArchive(archive);
            electroItem.setDescription(description);

            electroItemRepository.save(electroItem);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
