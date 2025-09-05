package io.github.code100.active;

/**
 * 模板方法模式
 */
public class TemplateMethodPattern {
    public static void main(String[] args) {
        MealTemplate chinese = new ChineseMeal();
        MealTemplate pizza = new PizzaMeal();

        System.out.println("=== 吃中餐流程 ===");
        chinese.prepareMeal();

        System.out.println("\n=== 吃披萨流程 ===");
        pizza.prepareMeal();
    }
}

abstract class MealTemplate {
    // 模板方法（不可改）
    public final void prepareMeal() {
        washHands();
        cook();
        eat();
        cleanUp();
    }

    private void washHands() {
        System.out.println("洗手准备吃饭~");
    }

    protected abstract void cook();   // 留给子类
    protected abstract void eat();    // 留给子类

    private void cleanUp() {
        System.out.println("洗碗刷锅收拾残局~");
    }
}

class ChineseMeal extends MealTemplate {
    @Override
    protected void cook() {
        System.out.println("炒菜 + 煮米饭");
    }

    @Override
    protected void eat() {
        System.out.println("用筷子吃中餐！");
    }
}

class PizzaMeal extends MealTemplate {
    @Override
    protected void cook() {
        System.out.println("加热披萨");
    }

    @Override
    protected void eat() {
        System.out.println("用手抓着吃披萨！");
    }
}
