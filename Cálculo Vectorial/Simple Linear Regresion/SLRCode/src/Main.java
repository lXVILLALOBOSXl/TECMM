public class Main {
    public static void main(String[] args) {
        DataSet ds = new DataSet(
                new double[]{1,1,1,1,1,1,1,1,1},
                new double[]{1,1,1,1,1,1,1,1,1}
        );

        System.out.println(ds);
        System.out.println("Sum x: " + DataSet.sum(ds.getX()));
        System.out.println("Sum y: " + DataSet.sum(ds.getY()));
    }
}
