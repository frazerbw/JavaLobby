package com.frazerbw.util;

import java.io.*;
import java.net.Socket;

/**
 * This handles the reading and writing of data to the user socket
 *
 * @author Frazer Bennett Wilford
 * @version 1.00
 */
public class UserSocket {
    private User parent; // User reference
    private DataInputStream input;
    private DataOutputStream output;

    /**
     * Sets references to the socket and user
     * @param socket user's socket reference
     * @param parent user reference
     */
    public UserSocket(Socket socket, User parent) {
        this.parent = parent;
        try {
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) { parent.disconnectUser(); }
    }

    /**
     * Tries to read an int from the socket
     * @return Returns the value read from the socket as an int
     */
    public int readInt() {
        try {
            return input.readInt();
        } catch (IOException e) { parent.disconnectUser(); }
        return -999;
    }

    /**
     * Tries to read an String from the socket
     * @return Returns the value read from the socket as an String
     */
    public String readUTF() {
        try {
            return input.readUTF();
        } catch (IOException e) { parent.disconnectUser(); }
        return "";
    }

    /**
     * Writes a String to the socket
     * @param string the String to be written to the socket
     */
    public void sendUTF(String string) {
        try {
            output.writeUTF(string);
        } catch (IOException e) { parent.disconnectUser(); }
    }

    /**
     * Writes a int to the socket
     * @param i the int to be written to the socket
     */
    public void sendInt(int i) {
        try {
            output.writeInt(i);
        } catch (IOException e) { parent.disconnectUser(); }
    }

    /**
     * Writes a boolean to the socket
     * @param b the boolean to be written to the socket
     */
    public void sendBool(boolean b) {
        try {
            output.writeBoolean(b);
        } catch (IOException e) { parent.disconnectUser(); }
    }

    /**
     * Flushes all written data from the socket
     */
    public void flushSocket() {
        try {
            output.flush();
        } catch (IOException e) { parent.disconnectUser(); }
    }
}
