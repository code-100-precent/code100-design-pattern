package io.github.code100.struct;

public class AdapterPattern {
    public static void main(String[] args) {
        SDCard sdCard = new SDCard();
        USB adapter = new SDToUSBAdapter(sdCard);
        Computer computer = new Computer();

        computer.useDevice(adapter);
    }
}

interface USB {
    void connectWithUSB();
}

class SDCard {
    public void connectWithSD() {
        System.out.println("SD卡已连接！");
    }
}

class SDToUSBAdapter implements USB {
    private SDCard sdCard;

    public SDToUSBAdapter(SDCard sdCard) {
        this.sdCard = sdCard;
    }

    @Override
    public void connectWithUSB() {
        System.out.println("通过适配器：");
        sdCard.connectWithSD();
    }
}
class Computer {
    public void useDevice(USB usb) {
        usb.connectWithUSB();
    }
}