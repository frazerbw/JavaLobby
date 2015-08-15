package com.frazerbw.lobby;

import java.net.*;

public class LobbyUser {

    Socket socket;

    public LobbyUser(Socket socket) {
        this.socket = socket;
    }

}
