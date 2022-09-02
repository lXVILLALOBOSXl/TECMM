/**
 * Luis Adrian Villalobos Rivera 2ISC 220120379 P1 TM
 * Class to make math operations
 */
public class Calculadora {

    private double n1, n2, result; //If you want to use methods with propierties

    /**
     * If you want to use the methods with arguments
     */
    public Calculadora() { }

    /**
     * If you want to use one number methods with properties
     * @param n1 number to be worked
     */
    public Calculadora(double n1) {
        this.n1 = n1;
    }

    /**
     * If you want to use two numbera methods with propierties
     * @param n1 number to be worked
     * @param n2 number to be worked
     */
    public Calculadora(double n1, double n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public double add(double n1, double n2){
        return n1 + n2;
    }

    public double add(){
        this.result = this.n1 + this.n2;
        return this.result;
    }

    public double subtract(double n1, double n2){
        return n1 - n2;
    }

    public double subtract(){
        this.result = this.n1 - this.n2;
        return this.result;
    }

    public double multiply(double n1, double n2){
        return n1 * n2;
    }

    public double multiply(){
        this.result = this.n1 * this.n2;
        return this.result;
    }

    public double split(double n1, double n2){
        return n1 / n2;
    }

    public double split(){
        this.result = this.n1 / this.n2;
        return this.result;
    }

    public boolean isPair(int n1){
        if(n1 % 2 == 0){
            return true;
        }
        return false;
    }

    public boolean isPair(){
        if((int)this.n1 % 2 == 0){
            return true;
        }
        return false;
    }

    public double factorial(double n1){
        if(n1 == 1){
            return 1;
        }
        return (n1 * factorial(n1-1) );
    }

    public double factorial(){
        return factorial(this.n1);
    }

    private int sumDivisors(int n1){
        int sum = 0;
        for (int i = 1; i < n1; i++){
            if(n1 % i == 0){
                sum+=i;
            }
        }
        return sum;
    }

    public boolean isPerfectNumber(int n1){
        return (n1 == sumDivisors(n1)) ? true : false;
    }

    public boolean isPerfectNumber(){
        return ((int)this.n1 == sumDivisors((int)this.n1)) ? true : false;
    }

    public boolean areFriendsNumbers(int n1, int n2){
        return (n1 == sumDivisors(n2) && n2 == sumDivisors(n1)) ? true : false;
    }

    public boolean areFriendsNumbers(){
        return ((int)this.n1 == sumDivisors((int)this.n2) &&(int)this.n2 == sumDivisors((int)this.n1)) ? true : false;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public double getN1() {
        return n1;
    }

    public double getN2() {
        return n2;
    }

    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Calculadora{" +
                "n1=" + n1 +
                ", n2=" + n2 +
                ", result=" + result +
                '}';
    }
}
