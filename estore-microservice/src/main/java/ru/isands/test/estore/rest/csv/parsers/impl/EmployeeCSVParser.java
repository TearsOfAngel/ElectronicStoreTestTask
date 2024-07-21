package ru.isands.test.estore.rest.csv.parsers.impl;

import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import ru.isands.test.estore.dao.entity.Employee;
import ru.isands.test.estore.dao.entity.PositionType;
import ru.isands.test.estore.dao.entity.Shop;
import ru.isands.test.estore.dao.repo.EmployeeRepository;
import ru.isands.test.estore.dao.repo.PositionTypeRepository;
import ru.isands.test.estore.dao.repo.ShopRepository;
import ru.isands.test.estore.rest.csv.parsers.CSVParserService;

import javax.persistence.EntityNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class EmployeeCSVParser implements CSVParserService {

    private final EmployeeRepository employeeRepository;

    private final ShopRepository shopRepository;

    private final PositionTypeRepository positionTypeRepository;

    public EmployeeCSVParser(EmployeeRepository employeeRepository, ShopRepository shopRepository, PositionTypeRepository positionTypeRepository) {
        this.employeeRepository = employeeRepository;
        this.shopRepository = shopRepository;
        this.positionTypeRepository = positionTypeRepository;
    }

    @Override
    public void parseAndSave(CSVRecord record) {
        Employee employeeToSave = new Employee();

        Long shopId = Long.valueOf(record.get(6));
        Long positionId = Long.valueOf(record.get(5));

        Shop shop = findShopById(shopId);
        PositionType positionType = findPositionTypeById(positionId);

        setEmployeeDetails(employeeToSave, record, shop, positionType);

        employeeRepository.save(employeeToSave);
    }

    private Shop findShopById(Long shopId) {
        return shopRepository.findById(shopId)
                .orElseThrow(() -> new EntityNotFoundException("Shop with id " + shopId + " not found"));
    }

    private PositionType findPositionTypeById(Long positionId) {
        return positionTypeRepository.findById(positionId)
                .orElseThrow(() -> new EntityNotFoundException("PositionType with id " + positionId + " not found"));
    }

    private void setEmployeeDetails(Employee employee, CSVRecord record, Shop shop, PositionType positionType) {
        employee.setId(Long.valueOf(record.get(0)));
        employee.setLastName(record.get(1));
        employee.setFirstName(record.get(2));
        employee.setPatronymic(record.get(3));
        employee.setBirthDate(parseDate(record.get(4)));
        employee.setPositionId(positionType);
        employee.setShopId(shop);
        employee.setGender(parseBoolean(record.get(7)));
    }

    private boolean parseBoolean(String value) {
        return "1".equals(value);
    }

    private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format: " + dateStr, e);
        }
    }
}
