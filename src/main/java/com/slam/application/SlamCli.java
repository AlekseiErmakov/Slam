package com.slam.application;

import com.slam.config.ApplicationConfig;
import com.slam.file.InputStreamProvider;
import com.slam.file.ScanFileLoader;
import com.slam.file.ScanFileLoaderImpl;
import com.slam.model.PointCloud;
import com.slam.service.PointCloudFactory;

import java.io.InputStream;
import java.util.List;

public class SlamCli extends Thread {

    private String firstFileName;
    private String secondFileName;
    private InputStreamProvider provider;
    private ScanFileLoader scanFileLoader;
    private PointCloudFactory pointCloudFactory;
    private ApplicationConfig applicationConfig;

    public SlamCli(String[] args) {
        firstFileName = args[0];
        secondFileName = args[1];
        provider = new InputStreamProvider();
        scanFileLoader = new ScanFileLoaderImpl();
        applicationConfig = ApplicationConfig.getConfig();
        pointCloudFactory = applicationConfig.getPointCloadFactory();
    }


    @Override
    public void run() {
        InputStream fileInputStreamFromFirstFile = provider.getFileInputStream(firstFileName);
        InputStream fileInputStreamFromSecondFile = provider.getFileInputStream(secondFileName);
        List<String> inputDataFromFirstFile = scanFileLoader.loadScan(fileInputStreamFromFirstFile);
        List<String> inputDataFromSecondFile = scanFileLoader.loadScan(fileInputStreamFromSecondFile);
        PointCloud pointCloudFromFirstFile = pointCloudFactory.getPointCloud(inputDataFromFirstFile);

        System.out.println("---------------------First file-------------------");
        System.out.println("---------------------" + firstFileName + "------------------");
        System.out.println("---------------------List Size--------------------");
        System.out.println(pointCloudFromFirstFile.getPoints().size());
        System.out.println("---------------------Points List--------------------");
        pointCloudFromFirstFile.getPoints().forEach(System.out::println);
        System.out.println("---------------------First file-------------------");
        System.out.println("---------------------" + secondFileName + "------------------");
        System.out.println("---------------------List Size--------------------");
        PointCloud pointCloudFromSecondFile = pointCloudFactory.getPointCloud(inputDataFromSecondFile);
        System.out.println("---------------------Points List--------------------");
        System.out.println(pointCloudFromSecondFile.getPoints().size());
        pointCloudFromSecondFile.getPoints().forEach(System.out::println);

    }
}
