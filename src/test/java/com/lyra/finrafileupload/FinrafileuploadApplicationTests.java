package com.lyra.finrafileupload;

import com.lyra.finrafileupload.controller.FileUploadController;
import com.lyra.finrafileupload.dao.FileUploadDao;
import com.lyra.finrafileupload.entity.FileMetaData;
import com.lyra.finrafileupload.exception.UploadFailException;
import com.lyra.finrafileupload.service.FileUploadService;
import com.lyra.finrafileupload.service.FileUploadServiceImp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FinrafileuploadApplicationTests {

	@Mock
	FileUploadDao fileUploadDao;

	@InjectMocks
	FileUploadServiceImp fileUploadServiceImp;

	@Mock
	FileUploadService fileUploadService;

	@InjectMocks
	FileUploadController fileUploadController;

	private static FileMetaData fileMetaData=new FileMetaData();

	@Before
	public void init(){
	    fileMetaData.setId(1);
		fileMetaData.setFileName("testFile");
		fileMetaData.setFileLocation("files/testFile");
		fileMetaData.setFileSize(100);
	}

	@Test
    public void findFileByIdServiceTest(){
        when(fileUploadDao.findOne(1)).thenReturn(fileMetaData);
        Assert.assertEquals(fileMetaData,fileUploadServiceImp.getFileById(1));
    }

    @Test
    public void findAllFilesServiceTest(){
        when(fileUploadDao.findAll()).thenReturn(new ArrayList<FileMetaData>(Arrays.asList(fileMetaData)));
        Assert.assertTrue(fileUploadServiceImp.getAllFiles().size()!=0);
    }

    @Test
    public void findFileByIdControllerTest(){
        when(fileUploadService.getFileById(1)).thenReturn(fileMetaData);
        Assert.assertEquals(fileMetaData,fileUploadController.getFileById("1"));
    }

    @Test
    public void findAllFilesControllerTest(){
        when(fileUploadService.getAllFiles()).thenReturn(new ArrayList<FileMetaData>(Arrays.asList(fileMetaData)));
        Assert.assertTrue(fileUploadController.getAllFiles().size()!=0);
    }

    @Test(expected = UploadFailException.class)
    public void findFileByIdNotExistTest() throws UploadFailException{
        when(fileUploadService.getFileById(2)).thenReturn(null);
        fileUploadController.getFileById("2");
    }

    @Test(expected = UploadFailException.class)
    public void findAllFilesNotExistTest() throws UploadFailException{
        when(fileUploadService.getAllFiles()).thenReturn(new ArrayList<FileMetaData>());
        fileUploadController.getAllFiles();
    }

}
