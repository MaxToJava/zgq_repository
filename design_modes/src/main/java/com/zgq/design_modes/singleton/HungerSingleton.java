package com.zgq.design_modes.singleton;


/**
 * 饿汉式
 * 线程安全，耗费资源
 *
 * @author zgq
 * @date 2020/10/30
 */
public class HungerSingleton {

    private static final HungerSingleton singletonInstance = new HungerSingleton();
    private HungerSingleton(){

    }

    public static HungerSingleton getSingletonInstance(){
        return singletonInstance;
    }
}
