package com.vrddd.introduction.generic;

public class MemoryCell {
    private Object storedValue;

    public void write(Object x){
        this.storedValue = x;
    }

    public Object read(){
        return storedValue;
    }
}
