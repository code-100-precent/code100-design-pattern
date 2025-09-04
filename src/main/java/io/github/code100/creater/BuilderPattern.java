package io.github.code100.creater;

// 三种方式对比构造 UserProfile 对象

import java.util.*;

public class BuilderPattern {
    public static void main(String[] args) {
        // 方式一：构造函数 + 多参数（易错、可读性差）
        UserProfile user1 = new UserProfile("Tom", 30, "深圳", true, false, "软件工程师", "读书、健身");
        System.out.println("构造函数方式：" + user1);

        // 方式二：new + setter（调用灵活，但容易漏掉某些字段）
        UserProfile user2 = new UserProfile();
        user2.setName("Tom");
        user2.setAge(30);
        user2.setCity("深圳");
        user2.setMarried(true);
        user2.setHasPet(false);
        user2.setJob("软件工程师");
        user2.setHobbies("读书、健身");
        System.out.println("Setter方式：" + user2);

        // 方式三：Builder 模式（链式调用、结构清晰）
        UserProfile user3 = new UserProfile.Builder()
                .name("Tom")
                .age(30)
                .city("深圳")
                .married(true)
                .hasPet(false)
                .job("软件工程师")
                .hobbies("读书、健身")
                .build();
        System.out.println("Builder方式：" + user3);
    }
}

class UserProfile {
    private String name;
    private int age;
    private String city;
    private boolean married;
    private boolean hasPet;
    private String job;
    private String hobbies;

    public UserProfile() {}

    public UserProfile(String name, int age, String city, boolean married, boolean hasPet, String job, String hobbies) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.married = married;
        this.hasPet = hasPet;
        this.job = job;
        this.hobbies = hobbies;
    }

    public static class Builder {
        private String name;
        private int age;
        private String city;
        private boolean married;
        private boolean hasPet;
        private String job;
        private String hobbies;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder married(boolean married) {
            this.married = married;
            return this;
        }

        public Builder hasPet(boolean hasPet) {
            this.hasPet = hasPet;
            return this;
        }

        public Builder job(String job) {
            this.job = job;
            return this;
        }

        public Builder hobbies(String hobbies) {
            this.hobbies = hobbies;
            return this;
        }

        public UserProfile build() {
            return new UserProfile(name, age, city, married, hasPet, job, hobbies);
        }
    }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setCity(String city) { this.city = city; }
    public void setMarried(boolean married) { this.married = married; }
    public void setHasPet(boolean hasPet) { this.hasPet = hasPet; }
    public void setJob(String job) { this.job = job; }
    public void setHobbies(String hobbies) { this.hobbies = hobbies; }

    @Override
    public String toString() {
        return "UserProfile{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", married=" + married +
                ", hasPet=" + hasPet +
                ", job='" + job + '\'' +
                ", hobbies='" + hobbies + '\'' +
                '}';
    }
}