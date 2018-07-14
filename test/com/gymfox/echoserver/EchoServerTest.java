package com.gymfox.echoserver;

import com.gymfox.communication.IPv4Address;
import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServerTest {

    @Test ( expected = EchoServer.ServerIsAlreadyRunningException.class )
    public void serverIsAlreadyRunningException() throws EchoServer.ServerIsAlreadyRunningException, InterruptedException, IOException, ServerUtils.InvalidPortException {
        EchoServer echoServer = new EchoServer();

        runServer(echoServer);
        echoServer.start();
    }

    @Test ( expected = ServerUtils.InvalidPortException.class )
    public void invalidPortExceptionTest() throws ServerUtils.InvalidPortException, EchoServer
            .ServerIsAlreadyRunningException, IOException {
        EchoServer echoServer = new EchoServer(5);

        echoServer.start();
    }

    @Test
    public void startConnectionTest() throws InterruptedException, IOException,
            ServerUtils.InvalidPortException {
        EchoServer echoServer = new EchoServer();
        WazzupClient wazzupClient = new WazzupClient(new IPv4Address("127.0.0.8"), 10010);

        runServer(echoServer);
        startConnection(wazzupClient);

        wazzupClient.stop();
        echoServer.stop();
    }

    @Test
    public void sendMessagesTest() throws ServerUtils.InvalidPortException,
            InterruptedException, IOException {
        Scanner in = new Scanner(System.in);
        String message = "hello";
        EchoServer echoServer = new EchoServer();
        WazzupClient wazzupClient = new WazzupClient(new IPv4Address("127.0.0.8"), 10010);

        runServer(echoServer);
        startConnection(wazzupClient);

        message = in.nextLine();

        wazzupClient.stop();
        echoServer.stop();
    }

    private void runServer(EchoServer echoServer) throws InterruptedException {
        Runnable r = () -> {
            try {
                echoServer.start();
            } catch (EchoServer.ServerIsAlreadyRunningException | IOException e) {
                e.printStackTrace();
            }
        };

        ExecutorService t = Executors.newFixedThreadPool(1);
        t.execute(r);
        Thread.sleep(5000);
    }

    private void startConnection(WazzupClient client) throws InterruptedException {
        Runnable r = () -> {
            try {
                client.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        ExecutorService t = Executors.newFixedThreadPool(1);
        t.execute(r);
        Thread.sleep(2000);
    }
}