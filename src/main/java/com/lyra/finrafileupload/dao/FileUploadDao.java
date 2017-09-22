package com.lyra.finrafileupload.dao;

import com.lyra.finrafileupload.entity.FileMetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadDao extends JpaRepository<FileMetaData,Integer>{
}
