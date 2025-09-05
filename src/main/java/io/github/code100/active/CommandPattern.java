package io.github.code100.active;

/**
 * 命令模式
 */
public class CommandPattern {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOnCommand = new LightOnCommand(light);
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(lightOnCommand);
        remoteControl.buttonWasPressed();
    }
}

interface Command {

    void execute();

    void undo();
}

class Light {
    public void on() {
        System.out.println("Light is on");
    }

    public void off() {
        System.out.println("Light is off");
    }
}

class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }

    public void undo() {
        light.off();
    }
}

class RemoteControl {

    Command onCommand;

    public void setCommand(Command command) {
        this.onCommand = command;
    }

    public void buttonWasPressed() {
        onCommand.execute();
    }

    public void undoButtonWasPressed() {
        onCommand.undo();
    }
}
