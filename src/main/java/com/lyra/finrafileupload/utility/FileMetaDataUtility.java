package com.lyra.finrafileupload.utility;

import com.lyra.finrafileupload.entity.FileMetaData;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileMetaDataUtility {

    static final File direction = new File("src/main/resources/files/");

    public static FileMetaData getFileMetaData(MultipartFile file){

        FileMetaData fileMetaData = new FileMetaData();

        fileMetaData.setFileName(file.getOriginalFilename());
        fileMetaData.setFileSize(file.getSize());
        fileMetaData.setFileLocation(direction.getAbsolutePath() + File.separator + file.getOriginalFilename());

        return fileMetaData;

    }

    public static void saveFileContent (MultipartFile file, FileMetaData fileMetaData) throws IOException{
        file.transferTo(new File(fileMetaData.getFileLocation()));
    }

}
