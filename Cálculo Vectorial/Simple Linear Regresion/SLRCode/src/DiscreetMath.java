public class DiscreetMath {
    public static double sum(double array[]){
        double sum = 0;
        for (double number: array) {
            sum += number;
        }
        return sum;
    }

    public static double sumMultiplication(double a[], double b[]){
        double sum = 0;
        int lenght = (a.length > b.length) ? a.length:b.length;

        for (int i = 0; i < lenght; i++) {
            sum += (a[i] * b[i]);
        }

        return sum;
    }

    public static double multiplySum(double a[], double b[]){
        return sum(a) * sum(b);
    }


}
