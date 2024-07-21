package ru.isands.test.estore.rest.csv.parsers.impl;

import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import ru.isands.test.estore.dao.entity.PurchaseType;
import ru.isands.test.estore.dao.repo.PurchaseTypeRepository;
import ru.isands.test.estore.rest.csv.parsers.CSVParserService;

@Service
public class PurchaseTypeCSVParser implements CSVParserService {

    private final PurchaseTypeRepository purchaseTypeRepository;

    public PurchaseTypeCSVParser(PurchaseTypeRepository purchaseTypeRepository) {
        this.purchaseTypeRepository = purchaseTypeRepository;
    }

    @Override
    public void parseAndSave(CSVRecord record) {
        PurchaseType purchaseType = new PurchaseType();
        purchaseType.setId(Long.valueOf(record.get(0)));
        purchaseType.setName(record.get(1));
        purchaseTypeRepository.save(purchaseType);
    }
}
