package com.lyra.finrafileupload.service;

import com.lyra.finrafileupload.dao.FileUploadDao;
import com.lyra.finrafileupload.entity.FileMetaData;
import com.lyra.finrafileupload.utility.FileMetaDataUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class FileUploadServiceImp implements FileUploadService {

    @Autowired
    private FileUploadDao fileUploadDao;

    @Override
    public void saveFile(MultipartFile file, FileMetaData fileMetaData) throws IOException {
        fileUploadDao.save(fileMetaData);
        FileMetaDataUtility.saveFileContent(file,fileMetaData);
    }

    @Override
    @Transactional(readOnly = true)
    public FileMetaData getFileById(Integer id) {
        return fileUploadDao.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FileMetaData> getAllFiles() {
        return fileUploadDao.findAll();
    }
}
