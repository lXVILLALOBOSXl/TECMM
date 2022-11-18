package com.main;

import com.dao.ProductDAO;
import com.dao.SalesmanDAO;
import com.dto.Client;
import com.dto.Invoice;
import com.dto.Saleman;
import com.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Run {
    private static List<Client> clients = new ArrayList<>();

    public static void main(String[] args) {
        do {
            menu(); //Print menu
        }while (operations(Util.askPositiveInt("option"))); //If option isn't exit*/
    }

    /**
     * Prints all kind of options
     */
    private static void menu(){
        System.out.println("\nWelcome to Invoices program! \n" +
                "1) Add Client\n" +
                "2) Add Saleman\n" +
                "3) Add Product\n" +
                "4) Sale\n" +
                "5) See invoices\n" +
                "6) Find Saleman\n" +
                "7) Exit\n");
    }

    /**
     * Asks and prints for the requested function
     * @param option function that the user want to use
     * @return if the menu will be printed again
     */
    private static boolean operations(int option){
        boolean repeat = true; //When the requested function finalizes, the option menu will be printed again

        switch (option){
            case 1:
                clients.add(new Client(Util.askString("name"),Util.askString("first last name"),Util.askString("second last name"),Util.askDate("birthday"),Util.askString("rfc"), Util.askString("address"),new ArrayList<>()));
                System.out.println("id: " + clients.size());
                return repeat;
            case 2:
                SalesmanDAO.create(Util.askSalesman(),SalesmanDAO.FILE_PATH,SalesmanDAO.TYPE_TOKEN);
                return repeat;
            case 3:
                ProductDAO.create(Util.askProduct(),ProductDAO.FILE_PATH,ProductDAO.TYPE_TOKEN);
                return repeat;
            case 4:
                makeInvoice(Util.askPositiveInt("client id"));
                return repeat;
            case 5:
                listInvoices(Util.askPositiveInt("cilent id"));
                return repeat;
            case 6:
                findSaleman(Util.askPositiveInt("sale id"));
                return repeat;
            case 7:
                System.out.println("Bye!");
                return !repeat;
            default: //If the option was a correct int but a incorrect option
                System.out.println("Incorrect option, please try again."); //advises to user
                operations(Util.askPositiveInt("option")); //requests a correct option again
                return repeat;
        }
    }

    private static Client findClient(int idClient){
        for (Client client : clients) {
            if(client.getId() == idClient){
                return client;
            }
        }
        System.out.println("Client didn't found");
        return null;
    }

    private static void findSaleman(int idSale){
        Saleman saleman;
        for (Object object : SalesmanDAO.getSalesMen()) {
            saleman = (Saleman) object;
            if(saleman.getId() == idSale){
                System.out.println(saleman);
                return;
            }
        }
        System.out.println("Saleman didn't found");
        return;
    }

    private static void makeInvoice(int idClient){
        Client client = findClient(idClient);
        if(client != null){
            client.getInvoices().add(new Invoice().makeInvoice());
        }else{
            return;
        }
    }

    private static void listInvoices(int idClient){
        Client client = findClient(idClient);
        if(client != null){
            for (Invoice invoice : client.getInvoices()) {
                System.out.println(invoice);
            }
        }else{
            return;
        }
    }



}
