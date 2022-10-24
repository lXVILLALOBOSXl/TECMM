package com.geometry;

public class Circle extends GeometricFigure implements IGeometricFigure {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        this.area = area();
        this.perimeter = perimeter();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * (Math.pow(this.radius,2));
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", area=" + area +
                ", perimeter=" + perimeter +
                '}';
    }
}
