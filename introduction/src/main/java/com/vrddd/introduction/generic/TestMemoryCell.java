package com.vrddd.introduction.generic;

public class TestMemoryCell {

    public static void main(String[] args) {
        MemoryCell memoryCell = new MemoryCell();
        memoryCell.write("haha");

        String val = (String)memoryCell.read();
        System.out.println("contents are :" + val);
    }

}
