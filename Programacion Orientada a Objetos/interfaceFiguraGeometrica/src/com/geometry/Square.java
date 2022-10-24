package com.geometry;

public class Square extends GeometricFigure implements IGeometricFigure{

    private double side;

    public Square(double side) {
        this.side = side;
        this.area = area();
        this.perimeter = perimeter();
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return Math.pow(this.side,2);
    }

    @Override
    public double perimeter() {
        return this.side * 4;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                ", area=" + area +
                ", perimeter=" + perimeter +
                '}';
    }
}
