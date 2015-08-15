package com.frazerbw.lobby;

import com.frazerbw.util.*;

import java.net.*;

public class LobbyUser extends Thread implements User {

    UserSocket userSocket;
    boolean connectedToServer = true;

    public LobbyUser(Socket socket) {
        userSocket = new UserSocket(socket, this);
    }

    public void run() {
        while (connectedToServer) {
            userSocket.sendUTF("Hello World!");
        }
    }

    public void disconnectUser() {
        connectedToServer = false;
    }

    public boolean isConnected() {
        return connectedToServer;
    }

}
