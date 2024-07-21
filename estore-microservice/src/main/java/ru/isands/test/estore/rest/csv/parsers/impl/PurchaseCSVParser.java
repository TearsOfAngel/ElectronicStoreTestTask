package ru.isands.test.estore.rest.csv.parsers.impl;

import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isands.test.estore.dao.entity.Employee;
import ru.isands.test.estore.dao.entity.Purchase;
import ru.isands.test.estore.dao.entity.PurchaseType;
import ru.isands.test.estore.dao.entity.Shop;
import ru.isands.test.estore.dao.repo.EmployeeRepository;
import ru.isands.test.estore.dao.repo.PurchaseRepository;
import ru.isands.test.estore.dao.repo.PurchaseTypeRepository;
import ru.isands.test.estore.dao.repo.ShopRepository;
import ru.isands.test.estore.rest.csv.parsers.CSVParserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PurchaseCSVParser implements CSVParserService {
    private final PurchaseRepository purchaseRepository;
    private final EmployeeRepository employeeRepository;
    private final ShopRepository shopRepository;
    private final PurchaseTypeRepository purchaseTypeRepository;

    public PurchaseCSVParser(PurchaseRepository purchaseRepository,
                             EmployeeRepository employeeRepository,
                             ShopRepository shopRepository,
                             PurchaseTypeRepository purchaseTypeRepository) {
        this.purchaseRepository = purchaseRepository;
        this.employeeRepository = employeeRepository;
        this.shopRepository = shopRepository;
        this.purchaseTypeRepository = purchaseTypeRepository;
    }

    @Override
    @Transactional
    public void parseAndSave(CSVRecord record) {
        try {
            Long electroId = Long.parseLong(record.get(1));
            Long employeeId = Long.parseLong(record.get(2));
            String purchaseDateString = record.get(3);
            Long typeId = Long.parseLong(record.get(4));
            Long shopId = Long.parseLong(record.get(5));

            Employee employee = employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid employee ID: " + employeeId));
            Shop shop = shopRepository.findById(shopId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid shop ID: " + shopId));
            PurchaseType purchaseType = purchaseTypeRepository.findById(typeId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid purchase type ID: " + typeId));

            Date purchaseDate = new SimpleDateFormat("dd.MM.yyyy HH:mm").parse(purchaseDateString);

            Purchase purchase = new Purchase();
            purchase.setElectroId(electroId);
            purchase.setEmployeeId(employee);
            purchase.setShopId(shop);
            purchase.setPurchaseDate(purchaseDate);
            purchase.setTypeId(purchaseType);

            purchaseRepository.save(purchase);
        } catch (NumberFormatException | ParseException e) {
            e.printStackTrace();
        }
    }
}
