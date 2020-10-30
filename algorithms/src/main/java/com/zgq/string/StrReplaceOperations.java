package com.zgq.string;

import org.junit.Test;

/**
 * TODO
 *
 * @author zgq
 * @date 2020/10/29
 */
public class StrReplaceOperations {

    /**
     * 将字符串转换为字符数组的方法
     * str.toCharArray()
     */
    @Test
    public void strReplace(){
        String str = "we are  happy.";
        char[] chars = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        for(char c : chars){
            if(c==' '){
                builder.append("%20");
            }else{
                builder.append(c);
            }
        }
        System.out.println(builder.toString());

    }

}
