package com.slam.util;

import com.slam.model.Point;

public class LandSurveyUtil {

    public static Point getPointByStraightTusk(Point root, double angle, double dimension){

        angle = angle >= 360 ? angle - 360 : angle;
        Double rootX = root.getX();
        Double rootY = root.getY();
        Point point = new Point();

        Double xIncrement = findXIncrement(angle,dimension);
        Double yIncrement = findYIncrement(angle,dimension);

        Double pointX = findPointX(rootX, xIncrement, angle);
        Double pointY = findPointY(rootY, yIncrement, angle);

        point.setX(pointX);
        point.setY(pointY);

        return point;
    }


    private static Double findPointX(Double rootX, Double xIncrement, double angle) {
        if (0 <= angle && angle <= 180){
            return rootX + xIncrement;
        }
        return rootX - xIncrement;
    }

    private static Double findPointY(Double rootY, Double yIncrement, double angle) {
        if (0 <= angle && angle <= 90 || 270 <= angle && angle <= 360){
            return rootY + yIncrement;
        }
        return rootY - yIncrement;
    }


    private static Double findXIncrement(double angle, double dimension) {
        return dimension * Math.cos(angle);
    }

    private static Double findYIncrement(double angle, double dimension) {
        return dimension * Math.sin(angle);
    }


}
