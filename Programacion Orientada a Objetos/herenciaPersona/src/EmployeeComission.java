public class EmployeeComission extends Employee {

    private double comissionPercentaje;
    private double moneySales;

    public EmployeeComission(String name, Date birthDay, int dni, double payment, double comissionPercentaje, double moneySales) {
        super(name, birthDay, dni, payment);
        this.comissionPercentaje = comissionPercentaje;
        this.moneySales = moneySales;
    }

    public void addSale(double amount){
        this.moneySales += amount;
    }

    public double getPayment() {
        return this.payment  + ((this.moneySales*this.comissionPercentaje)/100);
    }

    @Override
    public String toString() {
        return super.toString() + " EmployeeComission{" +
                "payment=" + payment +
                ", totalPayment=" + getPayment() +
                ", moneySales=" + moneySales +
                '}';
    }
}
