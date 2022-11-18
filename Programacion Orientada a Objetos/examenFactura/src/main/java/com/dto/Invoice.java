package com.dto;

import com.dao.ProductDAO;
import com.dao.SalesmanDAO;
import com.util.Util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private static int invoicesNumber = 0;
    private int id;
    private Date date;
    private double subtotal;
    private double taxes;
    private double total;
    private List<Product> buyedProducts;
    private Saleman saleman;

    public Invoice() {
    }

    public Invoice(Date date, double subtotal, double taxes, double total, List<Product> buyedProducts, Saleman saleman) {
        this.id = ++invoicesNumber;
        this.date = date;
        this.subtotal = subtotal;
        this.taxes = taxes;
        this.total = total;
        this.buyedProducts = buyedProducts;
        this.saleman = saleman;
    }

    public Invoice makeInvoice(){
        this.buyedProducts = new ArrayList<Product>();
        do {
            menu(); //Print menu
        }while (operations(Util.askPositiveInt("option")));

        return this;
    }

    private static void menu(){
        System.out.println("\nSubmenu \n" +
                "1) Add product\n" +
                "2) Delete product\n" +
                "3) Add Saleman\n" +
                "4) Make\n");
    }

    private boolean operations(int option){
        boolean repeat = true;

        switch (option){
            case 1:
                this.addProduct(Util.askPositiveInt("id product"));
                return repeat;
            case 2:
                this.deleteProduct(Util.askPositiveInt("id product"));
                return repeat;
            case 3:
                this.addSalesman(Util.askPositiveInt("id saleman"));
                return repeat;
            case 4:
                //it can't make a invoice without product or salesman
                if(this.buyedProducts.size() > 0 && this.saleman != null){
                    makedInvoice();
                    System.out.println("maked");
                    return !repeat;
                }else{
                    System.out.println("add products or saleman");
                    return repeat;
                }
            default: //If the option was a correct int but a incorrect option
                System.out.println("Incorrect option, please try again."); //advises to user
                operations(Util.askPositiveInt("option")); //requests a correct option again
                return repeat;
        }
    }

    private void addSalesman(int saleMan) {
        Saleman saleman = SalesmanDAO.find(saleMan);
        if ((saleman != null)) {
            this.saleman = saleman;
            System.out.println("salesman added");
        } else {
            System.out.println("Salesman didn't found");
        }
    }

    private void addProduct(int idProduct){
        Product product = ProductDAO.find(idProduct);
        if ((product != null)) {
            this.buyedProducts.add(product);
            System.out.println("product added");
        } else {
            System.out.println("Product didn't found");
        }
    }

    private void deleteProduct(int idProduct){
        for (Product product : this.buyedProducts) {
            if(product.getId() ==  idProduct){
               this.buyedProducts.remove(product);
                System.out.println("product deleted");
               return;
            }
        }
        System.out.println("Product isn't added");
    }

    /**
     * Create a new invoice and a new sale for a salesperson
     */
    private void makedInvoice() {
        this.id = ++invoicesNumber;
        LocalDate currentdate = LocalDate.now();
        this.date = new Date(currentdate.getDayOfMonth(),currentdate.getMonthValue(), currentdate.getYear());
        this.subtotal = this.subtotal();
        this.taxes = 16;
        this.total = this.total();
        this.saleman.sale(this.total);
    }


    private double subtotal() {
        double sum = 0;
        for (Product product : buyedProducts) {
            sum += product.getPrice();
        }
        return sum;
    }

    private double total() {
        return this.subtotal() + ((this.subtotal)*(this.taxes/100));
    }

    public static int getInvoicesNumber() {
        return invoicesNumber;
    }

    public static void setInvoicesNumber(int invoicesNumber) {
        Invoice.invoicesNumber = invoicesNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Product> getBuyedProducts() {
        return buyedProducts;
    }

    public void setBuyedProducts(List<Product> buyedProducts) {
        this.buyedProducts = buyedProducts;
    }

    public Saleman getSalesman() {
        return saleman;
    }

    public void setSalesman(Saleman saleman) {
        this.saleman = saleman;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", date=" + date +
                ", subtotal=" + subtotal +
                ", taxes=" + taxes +
                ", total=" + total +
                ", products=" + buyedProducts.toString() +
                ", saleman=" + saleman.toString() +
                '}';
    }
}
