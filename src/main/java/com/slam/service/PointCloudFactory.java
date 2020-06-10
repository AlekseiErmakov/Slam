package com.slam.service;

import com.slam.model.PointCloud;

import java.util.List;

public interface PointCloudFactory {
    void setEnableQualityFilter(boolean isEnable);
    void setQualityLimit(int qualityLimit);
    void setElementsToSkip(int elementsToSkip);
    int getCurrentQualityLimit();
    boolean isEnableQualityFilter();
    PointCloud getPointCloud(List<String> inputData);

}
