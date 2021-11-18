package io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerSecond {
    public static void main(String[] args) {
        Socket s = null;
        PrintStream ps = null;
        try {
            ServerSocket server = new ServerSocket(8030);
            s = server.accept();
            ps = new PrintStream(s.getOutputStream());
            ps.println("привет!");
            ps.flush();
        } catch (IOException e) {
            System.err.println("Ошибка соединения потока: " + e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
