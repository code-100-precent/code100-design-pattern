package io.github.code100.struct;

public class BridgePattern {
    public static void main(String[] args) {
        TV sony = new SonyTV();
        RemoteControl remote = new VoiceRemoteControl(sony);
        remote.turnOn();
        remote.changeChannel(5);
        remote.turnOff();

        System.out.println();

        TV samsung = new SamsungTV();
        RemoteControl anotherRemote = new VoiceRemoteControl(samsung);
        anotherRemote.turnOn();
        anotherRemote.changeChannel(8);
        anotherRemote.turnOff();
    }
}

interface TV {
    void on();
    void off();
    void switchChannel(int channel);
}

class SonyTV implements TV {
    public void on() {
        System.out.println("Sony TV 开机");
    }
    public void off() {
        System.out.println("Sony TV 关机");
    }
    public void switchChannel(int channel) {
        System.out.println("Sony TV 切换频道到 " + channel);
    }
}
class SamsungTV implements TV {
    public void on() {
        System.out.println("Samsung TV 开机");
    }
    public void off() {
        System.out.println("Samsung TV 关机");
    }
    public void switchChannel(int channel) {
        System.out.println("Samsung TV 切换频道到 " + channel);
    }
}

abstract class RemoteControl {
    protected TV tv;

    public RemoteControl(TV tv) {
        this.tv = tv;
    }

    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void changeChannel(int channel);
}


class VoiceRemoteControl extends RemoteControl {
    public VoiceRemoteControl(TV tv) {
        super(tv);
    }

    public void turnOn() {
        System.out.println("语音识别：开机！");
        tv.on();
    }

    public void turnOff() {
        System.out.println("语音识别：关机！");
        tv.off();
    }

    public void changeChannel(int channel) {
        System.out.println("语音识别：切换频道！");
        tv.switchChannel(channel);
    }
}