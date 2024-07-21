package ru.isands.test.estore.rest.csv.parsers.impl;

import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import ru.isands.test.estore.dao.entity.Shop;
import ru.isands.test.estore.dao.repo.ShopRepository;
import ru.isands.test.estore.rest.csv.parsers.CSVParserService;

@Service
public class ShopCSVParser implements CSVParserService {

    private final ShopRepository shopRepository;

    public ShopCSVParser(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public void parseAndSave(CSVRecord csvRecord) {
        Shop shop = new Shop();
        shop.setId(Long.valueOf(csvRecord.get(0)));
        shop.setName(csvRecord.get(1));
        shop.setAddress(csvRecord.get(2));
        shopRepository.save(shop);
    }
}
