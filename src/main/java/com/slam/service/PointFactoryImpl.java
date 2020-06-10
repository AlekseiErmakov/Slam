package com.slam.service;

import com.slam.model.Point;
import com.slam.util.LandSurveyUtil;

public class PointFactoryImpl implements PointFactory {

    private Point center;

    public PointFactoryImpl() {
        this.center = new Point();
        center.setX(0.0);
        center.setY(0.0);
    }

    @Override
    public Point createPoint(String lane) {
        Double angle = getAngle(lane);
        Double dimension = getDimension(lane);
        Integer quality = getQuality(lane);
        return getPoint(angle,dimension,quality);
    }

    @Override
    public void setCenter(Point center) {
        this.center = center;
    }

    private Double getAngle(String lane){
        return Double.parseDouble(lane.split(" ")[0]);
    }

    private Double getDimension(String lane){
        return Double.parseDouble(lane.split(" ")[1])/1000;
    }

    private Integer getQuality(String lane){
        return Integer.parseInt(lane.split(" ")[2]);
    }

    private Point getPoint(double angle, double dimension, int quality){
        Point point = LandSurveyUtil.getPointByStraightTusk(center,angle,dimension);
        point.setAngle(angle);
        point.setDimension(dimension);
        point.setQuality(quality);
        return point;
    }



}
