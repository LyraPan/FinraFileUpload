package com.lyra.finrafileupload.controller;

import com.lyra.finrafileupload.entity.FileMetaData;
import com.lyra.finrafileupload.exception.UploadFailException;
import com.lyra.finrafileupload.service.FileUploadService;
import com.lyra.finrafileupload.utility.FileMetaDataUtility;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping(value = "/upload")
    @ResponseBody
    public FileMetaData uploadFile(@RequestParam (value = "file", required = false) MultipartFile file) throws UploadFailException, IOException{
        if (file==null)
            throw new UploadFailException("Empty file!");
        FileMetaData fileMetaData= FileMetaDataUtility.getFileMetaData(file);
        fileUploadService.saveFile(file,fileMetaData);
        return fileMetaData;
    }

    @GetMapping(value = "/file/{id}")
    public FileMetaData getFileById(@PathVariable("id") String id) throws UploadFailException{
        Integer iid=Integer.parseInt(id);
        if (fileUploadService.getFileById(iid)==null) {
            throw new UploadFailException("File not exist!");
        }
        else return fileUploadService.getFileById(iid);
    }

    @GetMapping(value = "/file")
    public List<FileMetaData> getAllFiles()throws UploadFailException{
        if (fileUploadService.getAllFiles().isEmpty())
            throw new UploadFailException("No file founded!");
        return fileUploadService.getAllFiles();
    }

}
