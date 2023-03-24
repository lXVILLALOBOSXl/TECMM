import java.util.ArrayList;
import java.util.List;

public class Vector {
    private double[] coordinates;

    public Vector(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public double getCoordinate(int index) {
        return coordinates[index];
    }

    public int getDimension() {
        return coordinates.length;
    }

    public static Vector add(Vector vectorA, Vector vectorB) {
        if (vectorA.getDimension() != vectorB.getDimension()) {
            throw new IllegalArgumentException("Vectors must be of the same dimension.");
        }

        double[] resultCoordinates = new double[vectorA.getDimension()];

        for (int i = 0; i < vectorA.getDimension(); i++) {
            resultCoordinates[i] = vectorA.getCoordinate(i) + vectorB.getCoordinate(i);
        }

        return new Vector(resultCoordinates);
    }

    public static Vector subtract(Vector vectorA, Vector vectorB) {
        if (vectorA.getDimension() != vectorB.getDimension()) {
            throw new IllegalArgumentException("Vectors must be of the same dimension.");
        }

        double[] resultCoordinates = new double[vectorA.getDimension()];

        for (int i = 0; i < vectorA.getDimension(); i++) {
            resultCoordinates[i] = vectorA.getCoordinate(i) - vectorB.getCoordinate(i);
        }

        return new Vector(resultCoordinates);
    }

    public static double dotProduct(Vector vectorA, Vector vectorB) {
        if (vectorA.getDimension() != vectorB.getDimension()) {
            throw new IllegalArgumentException("Vectors must be of the same dimension.");
        }

        double result = 0.0;

        for (int i = 0; i < vectorA.getDimension(); i++) {
            result += vectorA.getCoordinate(i) * vectorB.getCoordinate(i);
        }

        return result;
    }

    public static Vector scalarMultiply(Vector vector, double scalar) {
        double[] resultCoordinates = new double[vector.getDimension()];

        for (int i = 0; i < vector.getDimension(); i++) {
            resultCoordinates[i] = scalar * vector.getCoordinate(i);
        }

        return new Vector(resultCoordinates);
    }

    public static double magnitude(Vector vector) {
        return Math.sqrt(Vector.dotProduct(vector, vector));
    }

    public static Vector normalize(Vector vector) {
        double magnitude = Vector.magnitude(vector);

        if (magnitude == 0.0) {
            throw new ArithmeticException("Cannot normalize a zero-length vector.");
        }

        return Vector.scalarMultiply(vector,(1.0 / magnitude));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for (int i = 0; i < this.getDimension(); i++) {
            sb.append(this.getCoordinate(i));

            if (i != this.getDimension() - 1) {
                sb.append(", ");
            }
        }

        sb.append(">");
        return sb.toString();
    }
}
