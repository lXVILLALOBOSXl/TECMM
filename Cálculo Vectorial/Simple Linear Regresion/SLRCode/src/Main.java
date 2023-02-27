public class Main {
    public static void main(String[] args) {
        DataSet dataSet = new DataSet(
                new double[]{1,1,1,1,1,1,1,1,1},
                new double[]{1,1,1,1,1,1,1,1,1}
        );

        System.out.println(dataSet);
        System.out.println("Sum x: " + DiscreetMath.sum(dataSet.getX()));
        System.out.println("Sum y: " + DiscreetMath.sum(dataSet.getY()));
    }
}
