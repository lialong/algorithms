package com.vrddd.generic;

public class TestMemoryInt {
    public static void main(String[] args) {
        MemoryCell memoryCell = new MemoryCell();
        memoryCell.write(new Integer(123));

        Integer val = (Integer)memoryCell.read();
        int intVal = val.intValue();
        System.out.println("contents are:" + intVal);
    }
}
