package com.zgq.array;

import org.junit.Test;

/**
 * 从特定的二维数组中判断是否存在给定的整数
 * 二维数组是行从左往右递增；列是从上往下递增
 *
 * 注意二维数组的初始化方法，还有数组的行和列为0的情况
 *
 * @author zgq
 * @date 2020/10/28
 */
public class TwoDimArrayTest {

    int[][] twoDimArray = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10,
            13, 14, 17, 24}, {18, 21, 23, 26, 30}};

    int givenInt = 3;
    boolean isExist = true;

    @Test
    public void test(){
      boolean flag = isExistGivenInt1(twoDimArray,givenInt);
        System.out.println(flag);
    }
    /**
     * 这个题目不适合用二分法，此外你还想用递归调用，这个也是不合适的
     * 这个方法不适合所有的情况
     */
    public void isExistGivenInt() {

        int[][] twoArray = new int[3][2];
        System.out.println(twoArray[1].length);

        int rows = twoDimArray.length;
        int columns = twoDimArray[0].length;

        if (twoDimArray[rows / 2][columns - 1] == givenInt) {
            System.out.println(isExist);
        } else if (twoDimArray[rows / 2 ][columns - 1] > givenInt) {
            for (int i = rows / 2 ; i >= 0; i--) {
                for(int j=columns-1;j>=0;j--){
                    if(twoDimArray[i][j]==givenInt){
                        System.out.println(isExist);
                        return;
                    }
                }
            }
        }else{
            for(int i=rows/2+1;i<rows;i++){
                for(int j=columns-1;j>=0;j--){
                    if(twoDimArray[i][j]==givenInt){
                        System.out.println(isExist);
                        return;
                    }
                }
            }
        }
        System.out.println(!isExist);
    }


    /**
     *  暴力破解法
     * @param maxtri
     * @param target
     * @return
     */
    public boolean isExistGivenInt(int[][] maxtri,int target){
        if(maxtri==null||maxtri.length==0||maxtri[0].length==0){
            return false;
        }
        int rows = maxtri.length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<maxtri[i].length;j++){
                if(maxtri[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 利用数组的行和列的有序性
     * @param maxtri
     * @param target
     * @return
     */
    public boolean isExistGivenInt1(int[][] maxtri,int target){
        if(maxtri==null||maxtri.length==0||maxtri[0].length==0){
            return false;
        }
        int rows = maxtri.length;
        int columns = maxtri[0].length;
        int row = 0;
        int column = columns-1;

        while(row<rows&&column>=0){
            if(maxtri[row][column]==target){
                return true;
            }else if(maxtri[row][column]>target){
                column--;
            }else{
                row++;
            }
        }
        return false;
    }

}
