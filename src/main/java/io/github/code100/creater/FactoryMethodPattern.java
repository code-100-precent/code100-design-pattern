package io.github.code100.creater;

public class FactoryMethodPattern {
    public static void main(String[] args) {
        FoodFactory factory;

        // 想吃披萨
        factory = new PizzaFactory();
        Food pizza = factory.createFood();
        pizza.eat();  // 输出：吃披萨，芝士拉丝好爽！

        // 想吃汉堡
        factory = new HamburgerFactory();
        Food hamburger = factory.createFood();
        hamburger.eat();  // 输出：咬汉堡，一口下去满满满足感！
    }
}

// 抽象产品
interface Food {
    void eat();
}

// 具体产品
class Pizza implements Food {
    @Override
    public void eat() {
        System.out.println("吃披萨，芝士拉丝好爽！");
    }
}

class Hamburger implements Food {
    @Override
    public void eat() {
        System.out.println("咬汉堡，一口下去满满满足感！");
    }
}

interface FoodFactory {
    Food createFood(); // 定义一个生产食物的方法
}

// 披萨工厂
class PizzaFactory implements FoodFactory {
    @Override
    public Food createFood() {
        return new Pizza();
    }
}

// 汉堡工厂
class HamburgerFactory implements FoodFactory {
    @Override
    public Food createFood() {
        return new Hamburger();
    }
}