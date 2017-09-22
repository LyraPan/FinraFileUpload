package com.lyra.finrafileupload.service;

import com.lyra.finrafileupload.entity.FileMetaData;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileUploadService {

    public void saveFile(MultipartFile file, FileMetaData fileMetaData) throws IOException;

    public FileMetaData getFileById(Integer id);

    public List<FileMetaData> getAllFiles();

}
