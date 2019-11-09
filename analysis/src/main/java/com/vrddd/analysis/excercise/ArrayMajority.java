package com.vrddd.analysis.excercise;

/**
 * @Author:along
 * @Description:
 * @Date:14:08 2019/11/9
 */
public class ArrayMajority {
    private static int find(int[] arr,int[] arr2,int length){
        if (length > 0){
            int length2 = length % 2 == 0 ? length : length - 1;
            int j = 0;
            for (int i = 0; i < length2; i += 2) {
                if(arr[i] == arr[i+1]){
                    arr2[j++] = arr[i];
                }
            }
            int major = find(arr2,arr,j);
            if(length % 2 == 1 && major == -1){
                major = length - 1;
            }
            return isMajority(arr,major) ? major : -1;
        }else{
            return -1;
        }
    }

    private static int find(int[] arr,int length){
        if (length > 0){
            int length2 = length % 2 == 0 ? length : length - 1;
            int j = 0;
            for (int i = 0; i < length2; i += 2) {
                if(arr[i] == arr[i+1]){
                    arr[j++] = arr[i];
                }
            }
            int major = find(arr,j);
            if(length % 2 == 1 && major == -1){
                major = length - 1;
            }
            return isMajority(arr,major) ? major : -1;
        }else{
            return -1;
        }
    }

    private static boolean isMajority(int[] arr,int major){
        if (major > 0){
            int length = arr.length;
            int times = 0;
            int half = length / 2;
            for (int i = 0; i < length; i++) {
                if (arr[i] == arr[major]){
                    times++;
                }
                if (times > half){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3,3};
        int[] arr2 = new int[arr.length];
        int major = find(arr,arr.length);
        if (major != -1){
            System.out.println(arr[major]);
        }else{
            System.out.println("there is no majority in array!");
        }
    }
}
