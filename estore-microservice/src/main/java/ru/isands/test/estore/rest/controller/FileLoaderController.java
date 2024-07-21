package ru.isands.test.estore.rest.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.isands.test.estore.rest.csv.fileloader.FileLoaderService;


@RequestMapping("/estore/api/shop")
@Tag(name = "Zip file loader", description = "Позволяет загрузить zip файл с csv файлами для загрузки их в БД")
@RestController
public class FileLoaderController {

    private final FileLoaderService fileLoaderService;

    public FileLoaderController(FileLoaderService fileLoaderService) {
        this.fileLoaderService = fileLoaderService;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Boolean> saveFile(@RequestPart(value = "file") final MultipartFile file) {
        boolean result = fileLoaderService.loadFile(file);
        return ResponseEntity.ok(result);
    }
}
