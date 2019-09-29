package com.vrddd.recursion;

public class PrintPermute {

    private static void permute(String str){
        permute(str.toCharArray(), 0, str.length() - 1);
    }

    private static void permute(char[] str, int low, int high){
        if (low < high){
            for (int i = low; i <= high; i++) {
                if (str[i] != str[low] && i != low){
                    char tmp = str[i];
                    str[i] = str[low];
                    str[low] = tmp;
                }
                if(low == 0 || i != low){
                    System.out.println(new String(str));
                }
                if (str[i] != str[low] && i != low){
                    char tmp = str[i];
                    str[i] = str[low];
                    str[low] = tmp;
                }
                permute(str, low+1, high);
            }
        }
    }

    public static void main(String[] args) {
        permute("abcd");
    }

}
