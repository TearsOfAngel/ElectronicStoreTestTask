package ru.isands.test.estore.rest.csv.fileloader;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.isands.test.estore.rest.csv.fileloader.FileLoaderService;
import ru.isands.test.estore.rest.csv.parsers.CSVParserService;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Slf4j
@Service
public class FileLoaderServiceImpl implements FileLoaderService {

    private final Map<String, CSVParserService> parserServices;

    private final String[] fileOrder;

    public FileLoaderServiceImpl(@Qualifier("parserServices") Map<String, CSVParserService> parserServices,
                                 String[] fileOrder) {
        this.parserServices = parserServices;
        this.fileOrder = fileOrder;
    }

    @Override
    public boolean loadFile(MultipartFile file) {
        if (file.isEmpty()) {
            log.error("File is empty");
            return false;
        }

        try {
            for (String filename : fileOrder) {
                InputStream inputStream = file.getInputStream();
                ZipInputStream zipInputStream = new ZipInputStream(inputStream);
                ZipEntry entry;
                while ((entry = zipInputStream.getNextEntry()) != null) {
                    if (entry.getName().equals(filename)) {
                        CSVParserService parserService = parserServices.get(filename);
                        if (parserService != null) {
                            log.info("Reading file: " + entry.getName());
                            try {
                                BufferedReader reader = new BufferedReader(new InputStreamReader(zipInputStream, Charset.forName("Windows-1251")));
                                reader.readLine();
                                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter(';').withTrim());
                                for (CSVRecord csvRecord : csvParser) {
                                    parserService.parseAndSave(csvRecord);
                                }
                            } catch (IOException e) {
                                log.error(e.getMessage());
                            }
                        } else {
                            log.error("No parser found for file: " + entry.getName());
                        }
                    }
                }

                zipInputStream.close();
                inputStream.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }
}
