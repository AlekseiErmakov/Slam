package com.slam.service;

import com.slam.model.Point;

public interface PointFactory {
    Point createPoint(String lane);
    void setCenter(Point center);
}
