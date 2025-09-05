package io.github.code100.active;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 */
public class ObserverPattern {
    public static void main(String[] args) {
        List<Observer> observers = new ArrayList<>();
        observers.add(new ConcreteObserver());
        observers.add(new ConcreteObserver2());
        observers.add(new ConcreteObserver3());
        for (Observer observer : observers){
            observer.message("观察者模式");
        }

    }
}

interface Observer {
    void message(String message);
}

class ConcreteObserver implements Observer {
    public void message(String message){
        System.out.println("观察者1收到消息：" + message);
    }
}

class ConcreteObserver2 implements Observer {
    public void message(String message){
        System.out.println("观察者2收到消息：" + message);
    }
}

class ConcreteObserver3 implements Observer {
    public void message(String message){
        System.out.println("观察者3收到消息：" + message);
    }
}

