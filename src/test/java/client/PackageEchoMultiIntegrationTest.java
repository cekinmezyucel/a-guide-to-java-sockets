package client;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PackageEchoMultiIntegrationTest {

    private static final int port = 6666;

    @Ignore
    @Test
    public void givenClient1_whenServerResponds_thenCorrect() {
        EchoClient client = new EchoClient();
        client.startConnection("127.0.0.1", port);
        String msg1 = client.sendMessage("hello");
        String msg2 = client.sendMessage("world");
        String terminate = client.sendMessage(".");

        assertEquals(msg1, "hello");
        assertEquals(msg2, "world");
        assertEquals(terminate, "bye");
        client.stopConnection();
    }

    @Ignore
    @Test
    public void givenClient2_whenServerResponds_thenCorrect() {
        EchoClient client = new EchoClient();
        client.startConnection("127.0.0.1", port);
        String msg1 = client.sendMessage("hello");
        String msg2 = client.sendMessage("world");
        String terminate = client.sendMessage(".");
        assertEquals(msg1, "hello");
        assertEquals(msg2, "world");
        assertEquals(terminate, "bye");
        client.stopConnection();
    }

    @Ignore
    @Test
    public void givenClient3_whenServerResponds_thenCorrect() {
        EchoClient client = new EchoClient();
        client.startConnection("127.0.0.1", port);
        String msg1 = client.sendMessage("hello");
        String msg2 = client.sendMessage("world");
        String terminate = client.sendMessage(".");
        assertEquals(msg1, "hello");
        assertEquals(msg2, "world");
        assertEquals(terminate, "bye");
        String terminate2 = client.sendMessage(".");
        assertNull(terminate2);
        client.stopConnection();
    }

}
