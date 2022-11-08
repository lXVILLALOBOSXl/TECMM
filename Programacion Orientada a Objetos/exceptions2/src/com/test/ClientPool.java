package com.test;

import com.Pool;
import com.exceptions.PoolLevelException;

public class ClientPool {

    public static void poolOperations(Pool p){
        try {
            for (int i = 1; i < 4 ; i++) {
                p.fill( (int) (Math.random() * 100));
                System.out.println("Filling... " + p.getLevel());
                p.empty( (int) (Math.random() * 100));
                System.out.println("Emptying... " + p.getLevel());
            }
        }catch (PoolLevelException e){
            System.out.println(e.toString() + ' ' + e.getLevel());
        }
    }

    public static void main(String[] args) {
        Pool p = new Pool(100);
        poolOperations(p);
    }
}
