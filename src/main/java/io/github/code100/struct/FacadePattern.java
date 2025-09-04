package io.github.code100.struct;

public class FacadePattern {
    public static void main(String[] args) {
        Projector projector = new Projector();
        Amplifier amplifier = new Amplifier();
        BluRayPlayer player = new BluRayPlayer();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(projector, amplifier, player);

        homeTheater.watchMovie();   // 一键开启
        System.out.println("--- 观影中 ---");
        homeTheater.endMovie();     // 一键关闭
    }
}

class Projector {
    public void on() {
        System.out.println("投影仪已开启");
    }
    public void off() {
        System.out.println("投影仪已关闭");
    }
}

class Amplifier {
    public void on() {
        System.out.println("功放已开启");
    }
    public void off() {
        System.out.println("功放已关闭");
    }
}

class BluRayPlayer {
    public void on() {
        System.out.println("蓝光播放器已开启");
    }
    public void play() {
        System.out.println("正在播放蓝光电影...");
    }
    public void off() {
        System.out.println("蓝光播放器已关闭");
    }
}

class HomeTheaterFacade {
    private Projector projector;
    private Amplifier amplifier;
    private BluRayPlayer player;

    public HomeTheaterFacade(Projector projector, Amplifier amplifier, BluRayPlayer player) {
        this.projector = projector;
        this.amplifier = amplifier;
        this.player = player;
    }

    public void watchMovie() {
        System.out.println("准备看电影！");
        projector.on();
        amplifier.on();
        player.on();
        player.play();
    }

    public void endMovie() {
        System.out.println("电影结束，关闭设备！");
        projector.off();
        player.off();
        amplifier.off();
    }
}