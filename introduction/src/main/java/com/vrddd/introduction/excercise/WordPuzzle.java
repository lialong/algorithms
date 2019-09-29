package com.vrddd.introduction.excercise;

/**
 * 字谜游戏求解
 * 这是一个行、列长度都为4的矩阵，可以从8个方向依次拼接单词
 * 以（行、列、方向）为一个三元组
 */
public class WordPuzzle {
    /**
     * 字谜数组
     */
    private static final char[][] arr = {{'t','h','i','s'},{'w','a','t','s'},{'o','a','h','g'},{'f','g','d','t'}};
    /**
     * 字谜数组行数
     */
    private static final int rowlen = arr.length;
    /**
     * 字谜数组列数
     */
    private static final int collen = arr[0].length;

    public static void main(String[] args) {
        for (int i = 0; i < rowlen; i++) {
            for (int j = 0; j < collen; j++) {
                for (int k = 0; k < 8; k++) {
                    StringBuilder sb = new StringBuilder("" + arr[i][j]);
                    getWord(arr,i,j,k,sb,4,false);
                }
            }
        }
    }
    /**
     * 某行、某列、某方向，所有可能拼接的单词
     * @param arr 字谜数组
     * @param row 字谜数组中起点的行数
     * @param col 字谜数组中起点的列数
     * @param direction 方向，参考坐标系象限，分成8个方向
     * @param sb 每个起点，每个方向，有一个装载字符的类
     * @param lenRestrict 长度限制，如传值4，表明只计算长度小于等于4的
     * @param isRange 是否输出长度限制内的所有单词拼接，false：仅输出长度限制长度的单词，true：输出长度限制范围内的所有单词
     */
    public static void getWord(char[][] arr,int row,int col,int direction,StringBuilder sb,int lenRestrict,boolean isRange){
        int length = 1;
        if (direction == 0){
            for (int l = col+1; l < collen; l++) {
                sb.append(arr[row][l]);
                if(++length > lenRestrict){
                    break;
                }else if(isRange){
                    System.out.format("%s_%s_%s:%s\n",row,col,direction,sb);
                }else if(length == lenRestrict){
                    System.out.format("%s_%s_%s:%s\n",row,col,direction,sb);
                }
            }
        }else if(direction == 1){
            for (int l = row-1,m = col+1; l >= 0 && m < collen; l--,m++) {
                sb.append(arr[l][m]);
                if(++length > lenRestrict){
                    break;
                }else if(isRange){
                    System.out.format("%s_%s_%s:%s\n",row,col,direction,sb);
                }else if(length == lenRestrict){
                    System.out.format("%s_%s_%s:%s\n",row,col,direction,sb);
                }
            }
        }else if(direction == 2){
            for (int l = row-1; l >= 0; l--) {
                sb.append(arr[l][col]);
                if(++length > lenRestrict){
                    break;
                }else if(isRange){
                    System.out.format("%s_%s_%s:%s\n",row,col,direction,sb);
                }else if(length == lenRestrict){
                    System.out.format("%s_%s_%s:%s\n",row,col,direction,sb);
                }
            }
        }else if(direction == 3){
            for (int l = row-1, m = col-1; l >= 0 && m >= 0; l--,m--) {
                sb.append(arr[l][m]);
                if(++length > lenRestrict){
                    break;
                }else if(isRange){
                    System.out.format("%s_%s_%s:%s\n",row,col,direction,sb);
                }else if(length == lenRestrict){
                    System.out.format("%s_%s_%s:%s\n",row,col,direction,sb);
                }
            }
        }else if(direction == 4){
            for (int l = col-1; l >= 0; l--) {
                sb.append(arr[row][l]);
                if(++length > lenRestrict){
                    break;
                }else if(isRange){
                    System.out.format("%s_%s_%s:%s\n",row,col,direction,sb);
                }else if(length == lenRestrict){
                    System.out.format("%s_%s_%s:%s\n",row,col,direction,sb);
                }
            }
        }else if(direction == 5){
            for (int l = row+1,m = col-1; l < rowlen && m >=0; l++,m--) {
                sb.append(arr[l][m]);
                if(++length > lenRestrict){
                    break;
                }else if(isRange){
                    System.out.format("%s_%s_%s:%s\n",row,col,direction,sb);
                }else if(length == lenRestrict){
                    System.out.format("%s_%s_%s:%s\n",row,col,direction,sb);
                }
            }
        }else if(direction == 6){
            for (int l = row+1; l < rowlen; l++) {
                sb.append(arr[l][col]);
                if(++length > lenRestrict){
                    break;
                }else if(isRange){
                    System.out.format("%s_%s_%s:%s\n",row,col,direction,sb);
                }else if(length == lenRestrict){
                    System.out.format("%s_%s_%s:%s\n",row,col,direction,sb);
                }
            }
        }else if(direction == 7){
            for (int l = row+1,m = col+1; l < rowlen && m < collen; l++,m++) {
                sb.append(arr[l][m]);
                if(++length > lenRestrict){
                    break;
                }else if(isRange){
                    System.out.format("%s_%s_%s:%s\n",row,col,direction,sb);
                }else if(length == lenRestrict){
                    System.out.format("%s_%s_%s:%s\n",row,col,direction,sb);
                }
            }
        }
    }
}
