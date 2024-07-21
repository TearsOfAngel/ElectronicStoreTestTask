package ru.isands.test.estore.rest.csv.parsers;

import org.apache.commons.csv.CSVRecord;

//TODO: подумать над названием интерфейса и имплементаций
public interface CSVParserService {

    void parseAndSave(CSVRecord record);
}
