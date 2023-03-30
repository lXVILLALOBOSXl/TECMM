public class VectorCalculator {
    public static void main(String[] args) {
        Vector a = new Vector(new double[]{3,3});
        Vector b = new Vector(new double[]{1,4});
        Vector c = new Vector(new double[]{4,7});
        System.out.println("A + B = " + a + " + "  + b + " = " + Vector.sum(a,b));
        System.out.println("A - B = " + a + " - "  + b + " = " + Vector.sub(a,b));
        System.out.println("7 * (A + C) = " + "7 * (" + a + " + "  + c + ") = " + Vector.scalarMultiply(Vector.sum(a,c),7));
        System.out.println("[7 * (A + B)] - C = " + "7 * (" + a + " + "  + b + ")] - " + c + " = " + Vector.sub(Vector.scalarMultiply(Vector.sum(a,b),7),c));
        System.out.println("||4(A) + 5(B) - C || = " + "||4(" + a + ") + 5(" + b + ") - " + c + "||" + " = " + Vector.magnitude(Vector.sub(Vector.sum(Vector.scalarMultiply(a,4),Vector.scalarMultiply(b,5)), c)));
        Vector u = new Vector(new double[]{3,3,2});
        Vector v = new Vector(new double[]{1,4,4});
        Vector w = new Vector(new double[]{4,7,5});
        Vector x = new Vector(new double[]{4,3,-5});
        System.out.println("||[(4(U) . 2(V))C] x W|| = " + "||(4(" + u + ") . 2(" + v + "))" +  x  + "] x " + w + "|| = " +
                Vector.magnitude( Vector.crossProduct(Vector.scalarMultiply(x,Vector.dotProduct(Vector.scalarMultiply(u,4),Vector.scalarMultiply(v,2))),w)));
    }

}
