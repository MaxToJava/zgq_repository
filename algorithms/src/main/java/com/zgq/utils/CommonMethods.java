package com.zgq.utils;

/**
 * TODO
 *
 * @author zgq
 * @date 2020/10/30
 */
public class CommonMethods {

    /**
     * 生成一个指定长度和最大值的数组
     * @param len
     * @param max
     * @return
     */
    public static int[] generateArray(int len, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr;
    }

    /**
     * 将数组以字符串的形式输出
     * @param arr
     * @return
     */
    public static String printArrayElements(int[] arr){

        StringBuilder builder = new StringBuilder();
        for(int e : arr){
            builder.append(e);
            builder.append(" ");
        }

        return builder.toString();
    }

}
