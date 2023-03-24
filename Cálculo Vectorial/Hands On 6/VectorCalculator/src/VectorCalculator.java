public class VectorCalculator {
    public static void main(String[] args) {
        double escalar = Math.PI;
        Vector vectorA = new Vector(new double[]{1,2});
        Vector vectorB = new Vector(new double[]{3,4});
        System.out.println(vectorA + " + "  + vectorB + " = " + Vector.add(vectorA, vectorB));
        System.out.println(vectorA + " - "  + vectorB + " = " + Vector.subtract(vectorA, vectorB));
        System.out.println(vectorA + " . "  + vectorB + " = " + Vector.dotProduct(vectorA, vectorB));
        System.out.println("||" + vectorA + "||" + " = " + Vector.magnitude(vectorA));
        System.out.println(vectorA + " normalize: " + Vector.normalize(vectorA));
        System.out.println(vectorA + " * " + escalar + " = " + Vector.scalarMultiply(vectorA,escalar));
    }

}
