public class QLR {
    private double b0;
    private double b1;
    private double b2;

    private DataSet dataSet;

    public QLR(DataSet dataSet) {
        this.dataSet = dataSet;
        this.b0 = calculateIntersect();
        this.b1 = calculateProjection();
        this.b2 = calculateWidht();
    }

    public void determinant(){
        System.out.println((((dataSet.getN() * DiscreetMath.sumPow(dataSet.getX(), 2) * DiscreetMath.sumPow(dataSet.getX(), 4)) +  (DiscreetMath.sum(dataSet.getX()) * DiscreetMath.sumPow(dataSet.getX(), 3) *  DiscreetMath.sumPow(dataSet.getX(), 2)  ) + (DiscreetMath.sumPow(dataSet.getX(), 2) * DiscreetMath.sum(dataSet.getX()) * DiscreetMath.sumPow(dataSet.getX(), 3))) - (Math.pow(DiscreetMath.sumPow(dataSet.getX(), 2),3)) - (dataSet.getN() * Math.pow(DiscreetMath.sumPow(dataSet.getX(), 3),2)) - (DiscreetMath.sumPow(dataSet.getX(), 4) * Math.pow(DiscreetMath.sum(dataSet.getX()),2))  ));
    }

    public double calculateIntersect(){
        return (  ((DiscreetMath.sum(dataSet.getY()) * DiscreetMath.sumPow(dataSet.getX(),2) * DiscreetMath.sumPow(dataSet.getX(),4)) + (DiscreetMath.sum(dataSet.getX()) * DiscreetMath.sumPow(dataSet.getX(),3) * DiscreetMath.sumMultiplication(dataSet.getY(), dataSet.getX(), 2)) + (DiscreetMath.sumPow(dataSet.getX(),2) * DiscreetMath.sumMultiplication(dataSet.getY(), dataSet.getX()) * DiscreetMath.sumPow(dataSet.getX(), 3))) - (DiscreetMath.sumMultiplication(dataSet.getY(), dataSet.getX(),2) * Math.pow(DiscreetMath.sumPow(dataSet.getX(), 2),2)) - (DiscreetMath.sum(dataSet.getY()) * Math.pow(DiscreetMath.sumPow(dataSet.getX(), 3),2)) - (DiscreetMath.sum(dataSet.getX()) * DiscreetMath.sumPow(dataSet.getX(), 4) * DiscreetMath.sumMultiplication(dataSet.getX(), dataSet.getY())) ) /
                (((dataSet.getN() * DiscreetMath.sumPow(dataSet.getX(), 2) * DiscreetMath.sumPow(dataSet.getX(), 4)) +  (DiscreetMath.sum(dataSet.getX()) * DiscreetMath.sumPow(dataSet.getX(), 3) *  DiscreetMath.sumPow(dataSet.getX(), 2)  ) + (DiscreetMath.sumPow(dataSet.getX(), 2) * DiscreetMath.sum(dataSet.getX()) * DiscreetMath.sumPow(dataSet.getX(), 3))) - (Math.pow(DiscreetMath.sumPow(dataSet.getX(), 2),3)) - (dataSet.getN() * Math.pow(DiscreetMath.sumPow(dataSet.getX(), 3),2)) - (DiscreetMath.sumPow(dataSet.getX(), 4) * Math.pow(DiscreetMath.sum(dataSet.getX()),2))  );
    }

    private double calculateProjection() {
        return (((dataSet.getN() * DiscreetMath.sumMultiplication(dataSet.getX(), dataSet.getY()) * DiscreetMath.sumPow(dataSet.getX(), 4)) + (DiscreetMath.sum(dataSet.getY()) * DiscreetMath.sumPow(dataSet.getX(), 3) * DiscreetMath.sumPow(dataSet.getX(), 2)) + (DiscreetMath.sumPow(dataSet.getX(), 2) * DiscreetMath.sum(dataSet.getX()) * DiscreetMath.sumMultiplication(dataSet.getY(), dataSet.getX(),2)))-(Math.pow(DiscreetMath.sumPow(dataSet.getX(), 2),2) * DiscreetMath.sumMultiplication(dataSet.getX(), dataSet.getY())) - (DiscreetMath.sumMultiplication(dataSet.getY(), dataSet.getX(),2) * DiscreetMath.sumPow(dataSet.getX(), 3) * dataSet.getN()) - (DiscreetMath.sumPow(dataSet.getX(), 4) * DiscreetMath.sum(dataSet.getX()) *DiscreetMath.sum(dataSet.getY()))) /
                (((dataSet.getN() * DiscreetMath.sumPow(dataSet.getX(), 2) * DiscreetMath.sumPow(dataSet.getX(), 4)) +  (DiscreetMath.sum(dataSet.getX()) * DiscreetMath.sumPow(dataSet.getX(), 3) *  DiscreetMath.sumPow(dataSet.getX(), 2)  ) + (DiscreetMath.sumPow(dataSet.getX(), 2) * DiscreetMath.sum(dataSet.getX()) * DiscreetMath.sumPow(dataSet.getX(), 3))) - (Math.pow(DiscreetMath.sumPow(dataSet.getX(), 2),3)) - (dataSet.getN() * Math.pow(DiscreetMath.sumPow(dataSet.getX(), 3),2)) - (DiscreetMath.sumPow(dataSet.getX(), 4) * Math.pow(DiscreetMath.sum(dataSet.getX()),2))  );
    }

    private double calculateWidht() {
        return (((dataSet.getN() * DiscreetMath.sumPow(dataSet.getX(), 2) * DiscreetMath.sumMultiplication(dataSet.getY(), dataSet.getX(),2)) + (DiscreetMath.sum(dataSet.getX()) * DiscreetMath.sumMultiplication(dataSet.getY(), dataSet.getX()) * DiscreetMath.sumPow(dataSet.getX(), 2)) + (DiscreetMath.sum(dataSet.getY()) * DiscreetMath.sum(dataSet.getX()) * DiscreetMath.sumPow(dataSet.getX(), 3)))-(Math.pow(DiscreetMath.sumPow(dataSet.getX(), 2),2) * DiscreetMath.sum(dataSet.getY())) - (dataSet.getN() * DiscreetMath.sumPow(dataSet.getX(), 3) * DiscreetMath.sumMultiplication(dataSet.getY(), dataSet.getX())) - (Math.pow(DiscreetMath.sum(dataSet.getX()),2)*DiscreetMath.sumMultiplication(dataSet.getY(), dataSet.getX(), 2))) /
                (((dataSet.getN() * DiscreetMath.sumPow(dataSet.getX(), 2) * DiscreetMath.sumPow(dataSet.getX(), 4)) +  (DiscreetMath.sum(dataSet.getX()) * DiscreetMath.sumPow(dataSet.getX(), 3) *  DiscreetMath.sumPow(dataSet.getX(), 2)  ) + (DiscreetMath.sumPow(dataSet.getX(), 2) * DiscreetMath.sum(dataSet.getX()) * DiscreetMath.sumPow(dataSet.getX(), 3))) - (Math.pow(DiscreetMath.sumPow(dataSet.getX(), 2),3)) - (dataSet.getN() * Math.pow(DiscreetMath.sumPow(dataSet.getX(), 3),2)) - (DiscreetMath.sumPow(dataSet.getX(), 4) * Math.pow(DiscreetMath.sum(dataSet.getX()),2))  );
    }

    public double getB0() {
        return b0;
    }

    public double getB1() {
        return b1;
    }

    public double getB2() {
        return b2;
    }

    public double predict(double x){
        return b0 + (b1 * x) + (b2 * Math.pow(x,2));
    }

    public String getEquation(){
        return "Y = " + b0 + " + " + b1 + "x + " + b2 + "x^2";
    }
}
