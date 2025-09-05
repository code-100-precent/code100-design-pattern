package io.github.code100.active;

/**
 * 责任链模式
 */
public class ResponsibilityChainPattern {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1(null);
        Handler handler2 = new ConcreteHandler2(handler1);
        Handler handler3 = new ConcreteHandler3(handler2);
        handler3.handle();
    }
}

interface Handler {
    void handle();
}

class ConcreteHandler1 implements Handler {
    private Handler successor;
    public ConcreteHandler1(Handler successor){
        this.successor = successor;
    }
    public void handle(){
        System.out.println("ConcreteHandler1处理");
        if(successor != null){
            successor.handle();
        }
    }
}

class ConcreteHandler2 implements Handler {
    private Handler successor;
    public ConcreteHandler2(Handler successor){
        this.successor = successor;
    }
    public void handle(){
        System.out.println("ConcreteHandler2处理");
        if(successor != null){
            successor.handle();
        }
    }
}
class ConcreteHandler3 implements Handler {
    private Handler successor;
    public ConcreteHandler3(Handler successor){
        this.successor = successor;
    }
    public void handle(){
        System.out.println("ConcreteHandler3处理");
        if(successor != null){
            successor.handle();
        }
    }
}
