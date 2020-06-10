package com.slam.config;

import com.slam.model.Point;
import com.slam.service.PointCloudFactory;
import com.slam.service.PointCloudFactoryImpl;
import com.slam.service.PointFactory;
import com.slam.service.PointFactoryImpl;

public class ApplicationConfig {
    private static ApplicationConfig applicationConfig;

    private ApplicationConfig() {}

    public static ApplicationConfig getConfig() {
        if (applicationConfig == null) {
            applicationConfig = new ApplicationConfig();
        }
        return applicationConfig;
    }

    public PointCloudFactory getPointCloadFactory() {
        PointCloudFactory cloudFactory = new PointCloudFactoryImpl(getPointFactory());
        cloudFactory.setEnableQualityFilter(true);
        cloudFactory.setQualityLimit(60);
        cloudFactory.setElementsToSkip(3);
        return cloudFactory;
    }

    private PointFactory getPointFactory() {
        PointFactory pointFactory = new PointFactoryImpl();
        Point center = new Point();
        center.setX(2000.000);
        center.setY(1000.000);
        pointFactory.setCenter(center);
        return pointFactory;
    }
}
