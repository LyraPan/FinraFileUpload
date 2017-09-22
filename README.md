# FinraFileUpload
This is a project for file uploading as well as store the metadata to the in memory database.

This is a RESTful API use Spring Boot, and includes the unit test.

The metadata stored in database includes: fileId, fileName, fileSize, and fileLocation.

URI| HttpMethod | Description  
--- | --- | ---   
/upload | Post | Upload a file to the memory
/file  | Get | Get all files' metadata stored in the database
/file/{id} | Get | Find the file's metadata by file id
