package client;

import org.junit.BeforeClass;
import org.junit.Test;
import server.EchoMultiServer;
import server.GreetServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

public class GreetIntegrationTest {

    private static int port;

    @BeforeClass
    public static void start() throws InterruptedException, IOException {

        // Take an available port
        ServerSocket s = new ServerSocket(0);
        port = s.getLocalPort();
        s.close();

        Executors.newSingleThreadExecutor().submit(() -> new GreetServer().start(port));
        Thread.sleep(500);
    }

    @Test
    public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() throws IOException {
        GreetClient client = new GreetClient();
        client.startConnection("127.0.0.1", port);
        String response = client.sendMessage("hello server");
        assertEquals("hello client", response);
    }

}
