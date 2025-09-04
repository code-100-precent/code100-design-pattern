package io.github.code100.creater;

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