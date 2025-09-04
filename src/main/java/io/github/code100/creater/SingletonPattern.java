package io.github.code100.creater;

import java.util.HashMap;
import java.util.Map;

public class SingletonPattern {

    // 饿汉式
    public static Map<String, Object> map = new HashMap<>();

    // 懒汉式
    public static Map<String, Object> maps;

    public SingletonPattern(){
        maps = new HashMap<>();
    }
}
