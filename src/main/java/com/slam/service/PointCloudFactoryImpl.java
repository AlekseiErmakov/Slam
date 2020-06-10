package com.slam.service;

import com.slam.model.Point;
import com.slam.model.PointCloud;

import java.util.List;
import java.util.stream.Collectors;

public class PointCloudFactoryImpl implements PointCloudFactory{

    private boolean isEnableQualityFilter;

    private int qualityLimit = 0;
    private int elementsToSkip = 3;

    private PointFactory pointFactory;

    public PointCloudFactoryImpl(PointFactory pointFactory){
        this.pointFactory = pointFactory;
    }

    @Override
    public void setEnableQualityFilter(boolean isEnableQualityFilter) {
        this.isEnableQualityFilter = isEnableQualityFilter;
    }

    @Override
    public void setQualityLimit(int qualityLimit) {
        this.qualityLimit = qualityLimit;
    }

    @Override
    public void setElementsToSkip(int elementsToSkip) {
        this.elementsToSkip = elementsToSkip;
    }

    @Override
    public int getCurrentQualityLimit() {
        return qualityLimit;
    }

    @Override
    public boolean isEnableQualityFilter() {
        return isEnableQualityFilter;
    }

    @Override
    public PointCloud getPointCloud(List<String> inputData) {

        List<Point> points = inputData.stream()
                .skip(elementsToSkip)
                .map(lane -> this.pointFactory.createPoint(lane))
                .collect(Collectors.toList());
        if (isEnableQualityFilter){
            points = filterPoints(points);
        }
        PointCloud pointCloud = new PointCloud();
        pointCloud.setPoints(points);
        return pointCloud;
    }

    private List<Point> filterPoints(List<Point> points) {
        return points.stream()
                .filter(point -> point.getQuality()>=qualityLimit)
                .collect(Collectors.toList());
    }
}
