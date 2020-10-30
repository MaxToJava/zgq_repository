package com.zgq.array;

import com.zgq.utils.CommonMethods;

/**
 * 关于数组的几种典型的排序方法
 *
 * @author zgq
 * @date 2020/10/30
 */
public class ArraySorts {

    public static void main(String[] args) {

        int[] arr = {3, 1, 53, 43, 67, 23, 90, 101};
        int length = arr.length;
        int[] result = new int[length];
        mergeSort_recursive(arr,result,0,length-1);
        String arrStr = CommonMethods.printArrayElements(result);
        System.out.println(arrStr);
    }

    /**
     * 冒泡排序
     */
    public static int[] bubbleSort(int[] array) {
        int length = array.length;
        int temp;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] insertionSort(int[] arr) {
        return null;
    }

    /**
     * 重点学习 归并排序
     *
     * @param arr
     * @return
     */
    public static void mergeSort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end) {
            return;
        }

        int length = end - start;
        int mid = (length >> 1)+start;
        int start1 = start;
        int end1 = mid;
        int start2 = mid + 1;
        int end2 = end;

        mergeSort_recursive(arr, result, start1, end1);
        mergeSort_recursive(arr, result, start2, end2);

        int k=start;
        while (start1 <= end1 && start2 <= end2) {
            result[k++] = arr[start1]<arr[start2]?arr[start1++] : arr[start2++];
        }

        while(start1<=end1){
            result[k++] = arr[start1++];
        }

        while(start2<=end2){
            result[k++] = arr[start2++];
        }

        //数组拆分后的合并逻辑，关键点
        for(k=start;k<=end;k++){
            arr[k] = result[k];
        }

    }

    public static int[] quickSort(int[] arr) {
        return null;
    }

    public static int[] topologicalSort(int[] arr) {
        return null;
    }

    public static int[] heapSort(int[] arr) {
        return null;
    }

    public static int[] bucketSort(int[] arr) {
        return null;
    }

}
