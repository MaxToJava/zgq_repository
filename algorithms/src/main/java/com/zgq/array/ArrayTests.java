package com.zgq.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


/**
 * TODO
 *
 * @author zgq
 * @date 2020/10/27
 */
public class ArrayTests {

    /**
     * 常规做法，时间复杂度O（n^2）,空间复杂度为O(n)
     */
    @Test
    public void getRepeatNumberInArray(){
        Map<Integer,Integer> repeatNumAndCount = new HashMap();

        int[] numbers = {2,5,4,6,32,23,3,23,23,54,45,54,45};
        for(int i : numbers){
            Integer count = 0;
            for(int j : numbers){
                if(i==j){
                    count++;
                }
            }
            if(count>1){
                repeatNumAndCount.put(i,count);
            }
        }

        System.out.println(repeatNumAndCount);

    }


    /**
     * 用索引和数据的关系来做，操作不当会出现数组越界和数据重复输出的问题，另外如果
     * 数组中的某个数据过大时，会浪费很大的内存空间的
     */
    @Test
    public void getRepeatNumberInArray1(){
        int[] numbers = {2,5,4,6,32,23,3,23,23,54,45,54,45};
        Arrays.sort(numbers);
        int arrayLenth = numbers.length;
        int newArrayLenth = numbers[arrayLenth-1]+1;
        int[] newArray = new int[newArrayLenth];
        System.out.println("新数组的第一个元素："+newArray[0]);
        for(int i=0;i<arrayLenth;i++){
            if(newArray[numbers[i]]==0){
                newArray[numbers[i]]=1;
                continue;
            }
            System.out.println("重复的数值是："+numbers[i]);
        }
    }

    /**
     * 先对数组进行排序，用到了快速排序的思想，时间复杂度O(nlogn),空间复杂度是O(logn)
     * 修改了元数据
     */
    @Test
    public void getRepeatNumberInArra2(){
        int[] numbers = {2,5,4,6,32,23,3,23,23,54,45,54,45};
        Arrays.sort(numbers);
        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i]==numbers[i+1]){
                System.out.println("重复的数值是："+numbers[i]);
            }
        }
    }

    /**
     * 利用HashSet无序不重复的特性
     */
    @Test
    public void getRepeatNumberInArra3(){
        int[] numbers = {2,5,4,6,32,23,3,23,23,54,45,54,45};
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num : numbers){
            if(set.contains(num)){
                System.out.println("重复的数据是："+num);
            }
            set.add(num);
        }

    }

}
