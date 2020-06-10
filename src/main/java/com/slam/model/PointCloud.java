package com.slam.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PointCloud {
    List<Point> points = new ArrayList<>();
}
