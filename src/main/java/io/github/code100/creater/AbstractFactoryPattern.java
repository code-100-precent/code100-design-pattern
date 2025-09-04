package io.github.code100.creater;

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        // 点中餐
        MealFactory factory = new ChineseMealFactory();
        MainDish dish = factory.createMainDish();
        Drink drink = factory.createDrink();
        dish.eat();
        drink.drink();

        // 点西餐
        factory = new WesternMealFactory();
        factory.createMainDish().eat();
        factory.createDrink().drink();
    }
}

// 主食接口
interface MainDish {
    void eat();
}

// 饮料接口
interface Drink {
    void drink();
}

// 中餐产品
class FriedRice implements MainDish {
    public void eat() {
        System.out.println("吃香喷喷的蛋炒饭！");
    }
}
class SoyMilk implements Drink {
    public void drink() {
        System.out.println("喝甜甜的豆浆！");
    }
}

interface MealFactory {
    MainDish createMainDish();
    Drink createDrink();
}

class ChineseMealFactory implements MealFactory {
    public MainDish createMainDish() {
        return new FriedRice();
    }

    public Drink createDrink() {
        return new SoyMilk();
    }
}

class WesternMealFactory implements MealFactory {
    public MainDish createMainDish() {
        return new Pizza1();
    }

    public Drink createDrink() {
        return new Coke();
    }
}


// 西餐产品
class Pizza1 implements MainDish {
    public void eat() {
        System.out.println("咬一口披萨，芝士爆炸！");
    }
}
class Coke implements Drink {
    public void drink() {
        System.out.println("冰可乐下肚，爽！");
    }
}

