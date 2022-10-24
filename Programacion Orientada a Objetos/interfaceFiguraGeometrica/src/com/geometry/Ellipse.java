package com.geometry;

public class Ellipse extends GeometricFigure implements IGeometricFigure{

    private double radiusA;
    private double radiusB;

    public Ellipse(double radiusA, double radiusB) {
        this.radiusA = radiusA;
        this.radiusB = radiusB;
        this.area = area();
        this.perimeter = perimeter();
    }

    public double getRadiusA() {
        return radiusA;
    }

    public void setRadiusA(double radiusA) {
        this.radiusA = radiusA;
    }

    public double getRadiusB() {
        return radiusB;
    }

    public void setRadiusB(double radiusB) {
        this.radiusB = radiusB;
    }

    @Override
    public double area() {
        return Math.PI * this.radiusA * this.radiusB;
    }

    @Override
    public double perimeter() {
        return (Math.PI * 2) * Math.sqrt(((Math.pow(this.radiusA,2))+(Math.pow(this.radiusB,2)))/2);
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "radiusA=" + radiusA +
                ", raiusB=" + radiusB +
                ", area=" + area +
                ", perimeter=" + perimeter +
                '}';
    }
}
