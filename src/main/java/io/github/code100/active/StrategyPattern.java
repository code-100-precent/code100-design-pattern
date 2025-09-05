package io.github.code100.active;

/**
 * 策略模式
 */
public class StrategyPattern {
    public static void main(String[] args) {
        DeliveryContext context = new DeliveryContext();

        context.setStrategy(new ExpressDelivery());
        context.sendOrder();  // 顺丰

        context.setStrategy(new FlashDelivery());
        context.sendOrder();  // 闪送

        context.setStrategy(new CheapDelivery());
        context.sendOrder();  // 驴的快跑
    }
}

interface DeliveryStrategy {
    void deliver();
}

class ExpressDelivery implements DeliveryStrategy {
    public void deliver() {
        System.out.println("顺丰：用最快的速度送达！");
    }
}

class FlashDelivery implements DeliveryStrategy {
    public void deliver() {
        System.out.println("闪送：一对一骑手送达！");
    }
}

class CheapDelivery implements DeliveryStrategy {
    public void deliver() {
        System.out.println("驴的快跑：便宜但慢，请耐心等待~");
    }
}

class DeliveryContext {
    private DeliveryStrategy strategy;

    public void setStrategy(DeliveryStrategy strategy) {
        this.strategy = strategy;
    }

    public void sendOrder() {
        if (strategy != null) {
            strategy.deliver();
        } else {
            System.out.println("请选择配送策略！");
        }
    }
}
