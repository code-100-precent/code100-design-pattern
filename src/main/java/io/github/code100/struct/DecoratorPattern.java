package io.github.code100.struct;

public class DecoratorPattern {
    public static void main(String[] args) {
        MilkTea milkTea = new OriginalMilkTea();
        milkTea = new Pearl(milkTea);
        milkTea = new Coconut(milkTea);

        System.out.println("点单：" + milkTea.getDescription());
        System.out.println("总价：" + milkTea.getCost() + " 元");
    }
}

interface MilkTea {
    String getDescription();
    double getCost();
}

class OriginalMilkTea implements MilkTea {
    public String getDescription() {
        return "原味奶茶";
    }

    public double getCost() {
        return 5.0;
    }
}

abstract class MilkTeaDecorator implements MilkTea {
    protected MilkTea base;

    public MilkTeaDecorator(MilkTea base) {
        this.base = base;
    }

    public String getDescription() {
        return base.getDescription();
    }

    public double getCost() {
        return base.getCost();
    }
}

class Pearl extends MilkTeaDecorator {
    public Pearl(MilkTea base) {
        super(base);
    }

    public String getDescription() {
        return base.getDescription() + " + 珍珠";
    }

    public double getCost() {
        return base.getCost() + 1.5;
    }
}

class Coconut extends MilkTeaDecorator {
    public Coconut(MilkTea base) {
        super(base);
    }

    public String getDescription() {
        return base.getDescription() + " + 椰果";
    }

    public double getCost() {
        return base.getCost() + 1.0;
    }
}