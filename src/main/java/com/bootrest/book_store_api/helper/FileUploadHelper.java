package com.bootrest.book_store_api.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    // public final String UPLOAD_DIR = "D:\\Bilal\\Software Development\\Java Full
    // Stack Development\\Codes\\Spring Boot
    // Codes\\book_store_api\\src\\main\\resources\\static\\images";

    // Dynamic Path
    public final String UPLOAD_DIR = new ClassPathResource("static/images/").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException {

    }

    public boolean uploadFile(MultipartFile file) {

        boolean isUploaded = false;

        try {
            // Read file
            // InputStream is = file.getInputStream();
            // byte[] data = new byte[is.available()];
            // is.read(data);

            // // Write File
            // FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + File.separator +
            // file.getOriginalFilename());
            // fos.write(data);
            // fos.close();

            // alternative of this
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);

            isUploaded = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isUploaded;
    }

}
