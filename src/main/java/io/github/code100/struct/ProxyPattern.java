package io.github.code100.struct;

public class ProxyPattern {
    public static void main(String[] args) {
        SpeakInterface proxyClass = new IsProxyClass(new ProxyClass());
        proxyClass.speak();
    }
}

interface SpeakInterface {
    String speak();
}

class ProxyClass implements SpeakInterface{
    private String name;

    public String speak(){
        System.out.println("你好");
        return "你还可以";
    }
}

class IsProxyClass implements SpeakInterface{
    private ProxyClass proxyClass;

    public IsProxyClass(ProxyClass proxyClass){
        this.proxyClass = proxyClass;
    }

    @Override
    public String speak() {
        System.out.println("增强功能");
        return proxyClass.speak();
    }
}