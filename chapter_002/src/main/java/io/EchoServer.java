package io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
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
                            break;
                        } else {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write(str.substring(str.indexOf("=") + 1).getBytes());
                            break;
                        }
                    }
                }
            }
        }
    }
}
