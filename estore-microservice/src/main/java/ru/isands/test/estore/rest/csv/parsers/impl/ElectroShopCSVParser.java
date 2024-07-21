package ru.isands.test.estore.rest.csv.parsers.impl;

import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isands.test.estore.dao.entity.ElectroItem;
import ru.isands.test.estore.dao.entity.ElectroShop;
import ru.isands.test.estore.dao.entity.Shop;
import ru.isands.test.estore.dao.repo.ElectroItemRepository;
import ru.isands.test.estore.dao.repo.ElectronicShopRepository;
import ru.isands.test.estore.dao.repo.ShopRepository;
import ru.isands.test.estore.rest.csv.parsers.CSVParserService;

@Service
public class ElectroShopCSVParser implements CSVParserService {
    private final ElectronicShopRepository electroShopRepository;
    private final ElectroItemRepository electroItemRepository;
    private final ShopRepository shopRepository;

    public ElectroShopCSVParser(ElectronicShopRepository electronicShopRepository,
                                ElectroItemRepository electroItemRepository,
                                ShopRepository shopRepository) {
        this.electroShopRepository = electronicShopRepository;
        this.electroItemRepository = electroItemRepository;
        this.shopRepository = shopRepository;
    }

    @Override
    @Transactional
    public void parseAndSave(CSVRecord record) {
        try {
            Long shopId = Long.parseLong(record.get(0));
            Long electronicItemId = Long.parseLong(record.get(1));
            int count = Integer.parseInt(record.get(2));

            Shop shop = shopRepository.findById(shopId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid shop ID: " + shopId));
            ElectroItem electroItem = electroItemRepository.findById(electronicItemId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid electronic item ID: " + electronicItemId));

            ElectroShop electroShop = new ElectroShop();
            electroShop.setShopId(shop);
            electroShop.setElectronicItemId(electroItem);
            electroShop.setCount(count);

            electroShopRepository.save(electroShop);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
