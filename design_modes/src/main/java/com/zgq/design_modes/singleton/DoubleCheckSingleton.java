package com.zgq.design_modes.singleton;

/**
 * 懒汉式
 * 双重检验，并且成员变量用volatile来修饰，保证了多线程下的可见性
 *
 * @author zgq
 * @date 2020/10/30
 */
public class DoubleCheckSingleton {
    private static volatile DoubleCheckSingleton instance ;
    private DoubleCheckSingleton(){
    }

    public static DoubleCheckSingleton getInstance(){
        if(instance==null){
            // instance = new DoubleCheckSingleton();
            synchronized (DoubleCheckSingleton.class){
                instance = new DoubleCheckSingleton();
            }
        }
        return instance;
    }

}
