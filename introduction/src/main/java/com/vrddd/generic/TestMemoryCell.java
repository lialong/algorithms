package com.vrddd.generic;

public class TestMemoryCell {

    public static void main(String[] args) {
        MemoryCell memoryCell = new MemoryCell();
        memoryCell.write("haha");

        String val = (String)memoryCell.read();
        System.out.println("contents are :" + val);
    }

}
