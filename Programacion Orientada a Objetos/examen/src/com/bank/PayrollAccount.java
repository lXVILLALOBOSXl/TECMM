package com.bank;

import com.util.Util;

import java.util.ArrayList;
import java.util.Date;

public class PayrollAccount extends Account{

    private ArrayList<Movement> movements;

    public PayrollAccount(double balance, Date creationDate, Client client, Movement movement) {
        super(balance, creationDate, client);
        this.movements = new ArrayList<>();
        this.movements.add(movement);
    }

    public ArrayList<Movement> getMovements() {
        return movements;
    }

    public void setMovements(ArrayList<Movement> movements) {
        this.movements = movements;
    }

    public void menu(){
        System.out.println("\nSub menu\n" +
                "1) Deposit\n" +
                "2) Withdrawal\n" +
                "3) Balance\n" +
                "4) Movements\n" +
                "0) Exit\n");
    }

    public boolean operations(int option){
        boolean repeat = true;

        switch (option){
            case 1:
                this.movements.add(this.deposit(Util.getDouble("amonut"),new Date()));
                System.out.println("Currently balance: " + this.getBalance());
                return repeat;
            case 2:
                double amount =Util.getDouble("amonut");
                while (!this.checkBalance(amount)){
                    amount =Util.getDouble("amonut");
                }
                this.movements.add(this.withdrawal(amount,new Date()));
                System.out.println("Currently balance: " + this.getBalance());
                return repeat;
            case 3:
                System.out.println("Currently balance: " + this.getBalance());
                return repeat;
            case 4: //find
                for (Movement movement : this.movements) {
                    System.out.println(movement);
                }
                return repeat;
            case 0: //Exit
                System.out.println("Bye!");
                return !repeat;
            default: //If the option was a correct int but a incorrect option
                System.out.println("Incorrect option, please try again."); //advises to user
                operations(Util.getInt("option")); //requests a correct option again
                return repeat;
        }
    }

    private Movement deposit(double amount, Date movementDate){
        Movement m = new Movement("deposit",movementDate,amount,this.getBalance(),(amount + this.getBalance()));
        this.setBalance((amount + this.getBalance()));
        return m;
    }

    private boolean checkBalance(double amount){
        if (amount > this.getBalance()){
            System.out.println("You don't have enough money, try again");
            return false;
        }
        return true;
    }

    private Movement withdrawal(double amount, Date movementDate){
        Movement m = new Movement("withdrawal",movementDate,amount,this.getBalance(),(amount - this.getBalance()));
        this.setBalance((this.getBalance() - amount));
        return m;
    }

    @Override
    public String toString() {
        return super.toString() + " / PayrollAccount{" +
                "movements=" + movements +
                '}';
    }
}
