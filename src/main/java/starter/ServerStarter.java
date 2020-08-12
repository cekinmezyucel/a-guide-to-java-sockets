package starter;

import server.EchoMultiServer;

import java.util.concurrent.Executors;

public class ServerStarter {

    public static void main(String[] args) throws InterruptedException {
        int port = Integer.parseInt(args[0]);
        Executors.newSingleThreadExecutor().submit(() -> new EchoMultiServer().start(port));
        Thread.sleep(500);
    }

}
