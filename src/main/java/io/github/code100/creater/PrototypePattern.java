package io.github.code100.creater;

import java.util.ArrayList;
import java.util.List;

public class PrototypePattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User();
        user.setName("牛马");

        User clone = (User) user.clone();
        System.out.println(clone.getName());
        // 输出牛马
    }
}

class User implements Cloneable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

// CharacterProto.java
class CharacterProto implements Cloneable {
    private String name;
    private int level;
    private List<String> inventory;

    public CharacterProto(String name, int level) {
        this.name = name;
        this.level = level;
        this.inventory = new ArrayList<>();
    }

    public void addItem(String item) {
        inventory.add(item);
    }

    public void show() {
        System.out.println("Name: " + name + ", Level: " + level + ", Inventory: " + inventory);
    }

    @Override
    public CharacterProto clone() {
        try {
            CharacterProto copy = (CharacterProto) super.clone();
            // 深拷贝可变字段
            copy.inventory = new ArrayList<>(this.inventory);
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone not supported", e);
        }
    }
}

// Usage
class PrototypeDemo {
    public static void main(String[] args) {
        CharacterProto original = new CharacterProto("Warrior", 5);
        original.addItem("Sword");
        original.addItem("Shield");

        CharacterProto clone = original.clone();
        clone.addItem("Potion"); // 只影响 clone 的 inventory

        System.out.println("Original:");
        original.show();
        System.out.println("Clone:");
        clone.show();
    }
}
