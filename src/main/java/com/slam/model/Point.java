package com.slam.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Point {
    private Double angle;
    private Double dimension;
    private Double x;
    private Double y;
    private Integer quality;
}
