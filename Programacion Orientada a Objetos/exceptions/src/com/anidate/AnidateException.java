package com.anidate;

public class AnidateException {
    public static void main(String[] args) {
        int num[] = {4,8,16,32,64,128,256,512};
        int den[] = {2,0,4,4,0,8};

        try{
            for (int i = 0; i < num.length + 1; i++) {
                try{
                    System.out.println(num[i] + "/" + den[i] + "=" + num[i]/den[i]);
                }catch (java.lang.ArithmeticException exception){
                    System.out.println("out of limit" + i);
                }
            }
        }catch (Throwable excep){
            System.out.println("Fatal exception");
        }
        System.out.println("Program continues here");
    }
}
