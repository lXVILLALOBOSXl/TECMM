package com.continu;

public class ContinueException {

    public static void divide(){
        int num[] = {4,8,16,32,64,128,256};
        int den[] = {2,0,4,4,0,8};

        for (int i = 0; i < num.length + 1; i++) {
            try{
                System.out.println(num[i] + "/" + den[i] + "=" + num[i]/den[i]);
            }catch (java.lang.ArithmeticException exception){
                System.out.println("Dividing by zero");
            }catch (java.lang.ArrayIndexOutOfBoundsException exception){
                System.out.println("out of index");
            }
        }
    }
}
