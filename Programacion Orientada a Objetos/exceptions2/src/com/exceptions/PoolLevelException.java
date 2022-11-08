package com.exceptions;

public class PoolLevelException extends Exception{
    private int level;

    public PoolLevelException(String description, int level) {
        super(description);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
