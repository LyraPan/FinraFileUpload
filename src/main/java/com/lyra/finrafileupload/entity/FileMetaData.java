package com.lyra.finrafileupload.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "file_meta_data")
public class FileMetaData implements Serializable{

    public static final long serialVersionUID = 516315345156615361L;

    @Id
    @Column(name = "file_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_size")
    private long fileSize;

    @Column(name = "file_location")
    private String fileLocation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    public String toString() {
        return "FileMetaData{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", fileSize='" + fileSize + '\'' +
                ", fileLocation='" + fileLocation + '\'' +
                '}';
    }
}
