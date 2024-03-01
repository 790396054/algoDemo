package com.leetcode.queue;

public class SingleMan {
    private SingleMan(){

    }

    private volatile static SingleMan instance;

    public static SingleMan getInstance() {
        if (instance == null) {
            synchronized (SingleMan.class) {
                if (instance == null) {
                    instance = new SingleMan();
                }
            }
        }
        return instance;
    }

    public void tt() {

    }
}
