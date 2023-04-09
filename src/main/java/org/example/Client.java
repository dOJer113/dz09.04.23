package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import static org.example.Server.HOST;
import static org.example.Server.PORT;

public class Client {
    public static void main(String... args){
        try(Socket Clientsocket = new Socket(HOST,PORT);
            PrintWriter out = new PrintWriter(Clientsocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(Clientsocket.getInputStream()))){
            out.println("Alex");
            System.out.println(in.readLine());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
