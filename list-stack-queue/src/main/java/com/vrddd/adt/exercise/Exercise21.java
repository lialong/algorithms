package com.vrddd.adt.exercise;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 检验平衡符号
 */
public class Exercise21 {
    private static final Stack<String> stack = new Stack<>();
    private static final Set<String> pascalLeftSymbol = new HashSet<>(4);
    private static final Set<String> pascalRightSymbol = new HashSet<>(4);
    static {
        pascalLeftSymbol.add("begin");
        pascalRightSymbol.add("end");
        pascalLeftSymbol.add("(");
        pascalRightSymbol.add(")");
        pascalLeftSymbol.add("[");
        pascalRightSymbol.add("]");
        pascalLeftSymbol.add("{");
        pascalRightSymbol.add("}");
    }

    private static boolean checkPascal(String str){
        return false;
    }

    public static void main(String[] args) {

    }
}
