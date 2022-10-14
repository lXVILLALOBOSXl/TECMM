public class Employee extends Person {

    protected double payment;

    public Employee(String name, Date birthDay, int dni, double payment) {
        super(name, birthDay, dni);
        this.payment = payment;
    }

    public double getPayment() {
        return payment;
    }

    @Override
    public String toString() {
        return super.toString() + " Employee{" +
                "payment=" + payment +
                '}';
    }
}
