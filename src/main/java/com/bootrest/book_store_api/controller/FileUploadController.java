package com.bootrest.book_store_api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bootrest.book_store_api.helper.FileUploadHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

        // Test Response
        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize());
        // System.out.println(file.getContentType());
        // System.out.println(file.getName());

        try {

            // File Validation
            if (file.isEmpty() || file == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please upload an Image");
            }

            if (!file.getContentType().equals("image/png")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only upload png type images");
            }

            // File upload code
            boolean f = fileUploadHelper.uploadFile(file);

            if (f) {
                // return ResponseEntity.ok("File Uploaded Successfull") ;

                // to generate image URL
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/")
                        .path(file.getOriginalFilename()).toUriString());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("Something went wrong");
    }
}
