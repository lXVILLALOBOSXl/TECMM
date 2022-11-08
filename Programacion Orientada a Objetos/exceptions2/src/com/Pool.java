package com;

import com.exceptions.PoolLevelException;

public class Pool {
    private  int level;
    public final int MAX_LEVEL;

    public Pool(int MAX_LEVEL) {
        if(MAX_LEVEL < 0){
            MAX_LEVEL = 0;
        }
        this.MAX_LEVEL = MAX_LEVEL;
    }

    public int getLevel() {
        return level;
    }

    public void empty(int quantity) throws PoolLevelException {
        if(this.level - quantity < 0){
            throw new PoolLevelException("Less quantity than zero",this.level - quantity);
        }else{
            this.level -= quantity;
        }
    }

    public void fill(int quantity) throws PoolLevelException{
        if(this.level + quantity > this.MAX_LEVEL){
            throw new PoolLevelException("Excesive fill", this.level + quantity);
        }else{
            this.level += quantity;
        }
    }
}
