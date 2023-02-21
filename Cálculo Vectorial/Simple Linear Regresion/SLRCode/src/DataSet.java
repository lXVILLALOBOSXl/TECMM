import java.util.Arrays;

public class DataSet {
    private double x[];
    private double y[];

    public DataSet() {
    }

    public DataSet(double[] x, double[] y) {
        this.x = x;
        this.y = y;
    }

    public double[]  getX() {
        return this.x;
    }

    public double[] getY() {
        return this.y;
    }

    public static double sum(double array[]){
        double sum = 0;
        for (double number: array) {
            sum += number;
        }
        return sum;
    }

    @Override
    public String toString() {
        return "DataSet{" +
                "x=" + Arrays.toString(x) +
                ", y=" + Arrays.toString(y) +
                '}';
    }
}
