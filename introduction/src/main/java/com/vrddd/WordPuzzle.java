package com.vrddd;

/**
 * 字谜游戏求解
 */
public class WordPuzzle {
    private static final char[][] arr = {{'t','h','i','s'},{'w','a','t','s'},{'o','a','h','g'},{'f','g','d','t'}};

    public static void main(String[] args) {
        int row = arr.length;
        int col = arr[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < 8; k++) {
                    StringBuilder sb = new StringBuilder();
                    if (k == 0){
                        int rightBoundary = col - j;
                        for (int l = j; l < rightBoundary; l++) {
                            sb.append(arr[i][l]);
                            System.out.format("%s_%s_%s_%s:%s",i,j,k,l,sb);
                        }
                    }else if(1==1){
                        for (int l = i,m = j; l >= 0 && m <= col; l--,m++) {
                            sb.append(arr[row][l]);
                            System.out.format("%s_%s_%s_%s:%s",i,j,k,l,sb);
                        }
                    }
                }
            }
        }
    }
}
