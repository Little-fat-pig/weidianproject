package com.example.loginmodule.service;

import io.minio.ObjectStat;

import java.io.InputStream;

/*
 *@author zhangxl
 *@Date 2024/9/28 10:54
 *@description
 */
public interface MinioService {

    void removeBucket(String bucketName);

    ObjectStat getObjectInfo(String bucketName, String objectName);

    void putObject(String bucketName, String objectName, InputStream stream, Long fileSize, String type) throws Exception;


    Boolean folderExists(String bucketName, String prefix);


    void createFolder(String bucketName, String path);

    String getObjectUrl(String bucketName, String objectName);
}
