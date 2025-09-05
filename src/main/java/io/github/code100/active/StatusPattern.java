package io.github.code100.active;

/**
 * 状态模式
 */
public class StatusPattern {
    public static void main(String[] args) {
        StatusContext context = new StatusContext();
        context.setStatus(new OpenStatus());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}

interface Status {
    void open();

    void close();

    void run();

    void stop();
}

class StatusContext {

    Status status;

    public void setStatus(Status status) {
        this.status = status;
    }

    public void open() {
        status.open();
    }

    public void close() {
        status.close();
    }

    public void run() {
        status.run();
    }

    public void stop() {
        status.stop();
    }
}

class OpenStatus implements Status {
    @Override
    public void open() {
        System.out.println("Open Status");
    }

    @Override
    public void close() {
        System.out.println("Close Status");
    }

    @Override
    public void run() {
        System.out.println("Run Status");
    }

    @Override
    public void stop() {
        System.out.println("Stop Status");
    }
}
