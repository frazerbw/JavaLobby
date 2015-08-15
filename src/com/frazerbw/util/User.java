package com.frazerbw.util;

/**
 * The user is handled here, all packets are passed on to their appropriate manager based on
 * which packet ID is sent through the socket.
 *
 * @author Frazer Bennett Wilford
 * @version 1.00
 */
public interface User {
    public void disconnectUser();
    public boolean isConnected();
}
