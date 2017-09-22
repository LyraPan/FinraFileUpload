package com.lyra.finrafileupload.exception;

public class UploadFailException extends RuntimeException{

    public static final long SerialVersionUID = -13542115384335313L;

    public UploadFailException(String message){
        super(message);
    }

}
