package ru.isands.test.estore.rest.csv.fileloader;

import org.springframework.web.multipart.MultipartFile;

public interface FileLoaderService {

    boolean loadFile(MultipartFile file);
}
