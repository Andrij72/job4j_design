package io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                        String str = in.readLine();
                        if (!str.isEmpty()) {
                            System.out.println(str);
                            if (str.contains("Exit")) {
                                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                out.write("Server shutdown!".getBytes());
                                out.flush();
                                in.close();
                                out.close();
                                server.close();
                                break;
                            } else if (str.contains("Hello")) {
                                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                out.write("Hello everybody!".getBytes());
                            } else {
                                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                out.write(str.substring(str.indexOf("=") + 1).getBytes());
                            }
                        }
                    }
                }
        } catch (Exception ex) {
            LOG.error("Write in log socket exception", ex.getStackTrace());
        }
    }
}
