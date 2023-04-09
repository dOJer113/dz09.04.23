package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 1111;
    public static final String HOST = "localhost";
    public static void main(String... args) {
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                try (Socket clienSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clienSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()))) {
                    System.out.println("Получено новое соединение");
                    final String name = in.readLine();
                    out.println(String.format("Привет %s, твой порт это %d", name, clienSocket.getPort()));
                }
            } catch (
                    IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
