package com.test;

import com.bank.*;
import com.util.Util;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    private static ArrayList<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {
        do {
            menu(); //Print menu
        }while (operations(Util.getInt("option"))); //If option isn't exist*/
    }

    private static void menu(){
        System.out.println("\nWelcome to Heritage program! \n" +
                "1) Create payroll account\n" +
                "2) Create inversion account\n" +
                "3) Find account by number\n" +
                "4) List payroll accounts\n" +
                "5) List inversion accounts\n" +
                "0) Exit\n");
    }

    private static boolean operations(int option){
        boolean repeat = true;

        switch (option){
            case 1:
                accounts.add(setPayrollAccount());
                System.out.println("Your number account is: " + accounts.size());
                return repeat;
            case 2:
                accounts.add(setInvertionAccount());
                System.out.println("Your number account is: " + accounts.size());
                return repeat;
            case 3:
                Main.find(Util.getInt("id"));
                return repeat;
            case 4:
                for (Account a: accounts) {
                    if(a instanceof PayrollAccount){
                        System.out.println(a);
                    }
                }
                return repeat;
            case 5:
                for (Account a: accounts) {
                    if(a instanceof InversionAccount){
                        System.out.println(a);
                    }
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

    private static Date setDate(){
       return new Date(Util.getInt("year"),Util.getInt("month"),Util.getInt("day"));
    }

    private static Client setClient(){
        return new Client(Util.getString("name"),Util.getString("last name"),Util.getString("adress"),Util.getString("city"),Util.getString("phone number"));
    }

    private static Movement firstMovement(double amount, Date movementDate){
        return new Movement("First",movementDate,amount,0d,amount);
    }


    private static Account setPayrollAccount(){
        double initialAmount = Util.getDouble("initial ammount");
        Date creationDate = setDate();
        return new PayrollAccount(initialAmount, creationDate , setClient(), firstMovement(initialAmount,creationDate));
    }

    private static Account setInvertionAccount(){
        double initialAmount = Util.getDouble("initial ammount");
        Date creationDate = setDate();
        return new InversionAccount(initialAmount, creationDate , setClient(), Util.getInt("term"),Util.getInt("interest"));
    }


    private static void find(int id){

        for (Account account : accounts) {

            if(id == account.getAccountNumber()){
                if(account instanceof PayrollAccount){
                    do {
                        ((PayrollAccount) account).menu();
                    }while (((PayrollAccount) account).operations(Util.getInt("option"))); //If option isn't exist*/
                    return;
                }else if(account instanceof  InversionAccount){
                    ((InversionAccount) account).proyectInvertion();
                    return;
                }
            }
        }
        System.out.println("Doesn't exist");
    }

}
