package ru.isands.test.estore.rest.csv.fileloader.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.isands.test.estore.rest.csv.parsers.CSVParserService;
import ru.isands.test.estore.rest.csv.parsers.impl.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ParserConfig {

    @Bean
    public Map<String, CSVParserService> parserServices(
            ShopCSVParser shopCSVParser,
            PositionTypeCSVParser positionTypeCSVParser,
            PurchaseTypeCSVParser purchaseTypeCSVParser,
            PurchaseCSVParser purchaseCSVParser,
            ElectroItemCSVParser electroItemCSVParser,
            ElectroEmployeeCSVParser electroEmployeeCSVParser,
            ElectroShopCSVParser electroShopCSVParser,
            ElectroTypeCSVParser electroTypeCSVParser,
            EmployeeCSVParser employeeCSVParser) {

        Map<String, CSVParserService> parserServices = new HashMap<>();
        parserServices.put("Shop.csv", shopCSVParser);
        parserServices.put("PositionType.csv", positionTypeCSVParser);
        parserServices.put("PurchaseType.csv", purchaseTypeCSVParser);
        parserServices.put("Purchase.csv", purchaseCSVParser);
        parserServices.put("ElectroItem.csv", electroItemCSVParser);
        parserServices.put("ElectroEmployee.csv", electroEmployeeCSVParser);
        parserServices.put("ElectroShop.csv", electroShopCSVParser);
        parserServices.put("ElectroType.csv", electroTypeCSVParser);
        parserServices.put("Employee.csv", employeeCSVParser);
        return parserServices;
    }

    @Bean
    public String[] fileOrder() {
        return new String[] {
                "PurchaseType.csv",
                "Shop.csv",
                "PositionType.csv",
                "ElectroType.csv",
                "Employee.csv",
                "ElectroEmployee.csv",
                "Purchase.csv",
                "ElectroItem.csv",
                "ElectroShop.csv"
        };
    }
}
