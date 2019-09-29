package com.vrddd.recursion;

public class PrintPermute {

    private static void permute(String str){
        permute(str.toCharArray(), 0, str.length() - 1);
    }

    private static void swap(char[] str, int idx1, int idx2){
        char tmp = str[idx1];
        str[idx1] = str[idx2];
        str[idx2] = tmp;
    }

    private static void permute(char[] str, int low, int high){
        if (low < high){
            for (int i = low; i <= high; i++) {
                boolean flag = str[i] != str[low] && i != low;
                if (flag){
                    swap(str, i, low);
                }
                permute(str, low+1, high);
                if (flag){
                    swap(str, i, low);
                }
            }
        }else{
            System.out.println(new String(str));
        }
    }

    public static void main(String[] args) {
        permute("abcd");
    }

}
