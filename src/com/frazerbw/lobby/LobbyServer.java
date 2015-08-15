package com.frazerbw.lobby;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LobbyServer extends Thread {

    private boolean isServerOnline = true;
    private ServerSocket serverSocket;

    public LobbyServer() {

    }

    public void run() {
        createServer();
        runServer();
    }

    private void createServer() {
        try {
            serverSocket = new ServerSocket(LobbySettings.LOBBY_PORT);
        } catch (IOException e) {
            System.out.println("Lobby Server has failed to open.");
        }
    }

    private void runServer() {
        while (isServerOnline) {
            serverLoop();
        }
    }

    private void serverLoop() {
        try {
            acceptNewUsers();
        } catch (IOException e) {
            // Expected behavior (will call often)
        }
    }

    private void acceptNewUsers() throws IOException {
        Socket socket = serverSocket.accept();
        LobbyUser user = new LobbyUser(socket);
        user.start();
        System.out.println("New user has joined the lobby.");
    }

}
