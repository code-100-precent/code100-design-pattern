package io.github.code100.creater;

import com.sun.org.slf4j.internal.Logger;

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


//题目1：单例模式
//
//假设你正在开发一个日志记录系统，系统中的日志管理器应该是一个全局唯一的对象。请用单例模式来实现日志管理器类。

class LoggerManager {
    private static Logger logger;

    private static Logger log2 = new Logger("LoggerManager");

    private LoggerManager() {
        logger = new Logger("LoggerManager");
    }

    public static Logger getInstance() {
        if (logger == null) {
            synchronized (LoggerManager.class) {
                if (logger == null) {
                    logger = new Logger("LoggerManager");
                }
            }
        }
        return logger;
    }
}
